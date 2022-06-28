package cd2tec.JavaTest.controllers;

import cd2tec.JavaTest.dtos.EnderecoDto;
import cd2tec.JavaTest.dtos.EntregaDto;
import cd2tec.JavaTest.models.EntregaModel;
import cd2tec.JavaTest.services.EntregaService;
import cd2tec.JavaTest.utils.SigaBemUtils;
import cd2tec.JavaTest.views.EntregaView;
import com.google.gson.Gson;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/consulta-entrega")
public class SigaBemController {

    @Autowired
    EntregaService entregaService;

    //"/{peso}/{cepOrigem}/{cepDestino}/{nomeDestinatario}/"
    /*
    * @PathVariable Double peso,
      @PathVariable String cepOrigem,
      @PathVariable String cepDestino,
      @PathVariable String nomeDestinatario
    * */
    @PostMapping("/")
    public ResponseEntity<Object> saveEntrega(@RequestBody @Valid EntregaDto entregaDto) throws Exception {


        //Get external public API
        //endereço origem
        URL urlOrigem = new URL("https://viacep.com.br/ws/" + entregaDto.getCepOrigem() + "/json/");
        URLConnection urlConnOrigem = urlOrigem.openConnection();
        InputStream streamOrigem = urlConnOrigem.getInputStream();
        BufferedReader readerOrigem = new BufferedReader(new InputStreamReader(streamOrigem, "UTF-8"));

        EnderecoDto enderecoOrigemDto = new EnderecoDto();

        String enderecoOrigem = "";
        StringBuilder jsonEnderecoOrigem = new StringBuilder();

        while ((enderecoOrigem = readerOrigem.readLine()) != null) {
            jsonEnderecoOrigem.append(enderecoOrigem);
        }

        //endereço destino
        URL urlDestino = new URL("https://viacep.com.br/ws/" + entregaDto.getCepDestino() + "/json/");
        URLConnection urlConnDestino = urlDestino.openConnection();
        InputStream streamDestino = urlConnDestino.getInputStream();
        BufferedReader readerDestino = new BufferedReader(new InputStreamReader(streamDestino, "UTF-8"));

        EnderecoDto enderecoDestinoDto = new EnderecoDto();

        String enderecoDestino = "";
        StringBuilder jsonEnderecoDestino = new StringBuilder();

        while ((enderecoDestino = readerDestino.readLine()) != null) {
            jsonEnderecoDestino.append(enderecoDestino);
        }

        //test
        System.out.println(jsonEnderecoDestino.toString());

        enderecoOrigemDto = new Gson().fromJson(jsonEnderecoOrigem.toString(), EnderecoDto.class);
        enderecoDestinoDto = new Gson().fromJson(jsonEnderecoDestino.toString(), EnderecoDto.class);
        //


        EntregaModel entregaModel = new EntregaModel();

        EntregaDto entregaDtoFromCalculo = SigaBemUtils.calculaFrete(entregaDto.getPeso(), enderecoOrigemDto.getDdd(), enderecoOrigemDto.getUf(), enderecoDestinoDto.getDdd(), enderecoDestinoDto.getUf());

        entregaDto.setDataConsulta(entregaDtoFromCalculo.getDataConsulta());
        entregaDto.setDataPrevistaEntrega(entregaDtoFromCalculo.getDataPrevistaEntrega());
        entregaDto.setValorFrete(entregaDtoFromCalculo.getValorFrete());


        BeanUtils.copyProperties(entregaDto, entregaModel);

        //save to DB
        entregaService.save(entregaModel);

        //show on response
        //vlTotalFrete” e “dataPrevistaEntrega”, “cepOrigem” e “cepDestino”
        EntregaView entregaView = new EntregaView();

        entregaView.setValorFrete(entregaDtoFromCalculo.getValorFrete());
        entregaView.setDataPrevistaEntrega(entregaDtoFromCalculo.getDataPrevistaEntrega());
        entregaView.setCepOrigem(entregaDto.getCepOrigem());
        entregaView.setCepDestino(entregaDto.getCepDestino());

        return ResponseEntity.status(HttpStatus.CREATED).body(entregaView);

    }
}
