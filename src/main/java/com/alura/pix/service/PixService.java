package com.alura.pix.service;

import com.alura.pix.avro.PixRecord;
import com.alura.pix.dto.PixDTO;
import com.alura.pix.model.Pix;
import com.alura.pix.repository.PixRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PixService {

    @Autowired
    private final PixRepository pixRepository;

//    @Autowired
//    private final KafkaTemplate<String, PixRecord> kafkaTemplate;

    //Como vou usar o kafka connect nao preciso mais fazer o produtor mandar para o topico do kafka
    public PixDTO salvarPix(PixDTO pixDTO) {
        pixRepository.save(Pix.toEntity(pixDTO));
//        PixRecord pixRecord = PixRecord.newBuilder()
//                .setIdentificador(pixDTO.getIdentifier())
//                .setChaveOrigem(pixDTO.getChaveOrigem())
//                .setChaveDestino(pixDTO.getChaveDestino())
//                .setStatus(pixDTO.getStatus().toString())
//                .setDataTransferencia(pixDTO.getDataTransferencia().toString())
//                .build();
//
//        kafkaTemplate.send("pix-topic", pixDTO.getIdentifier(), pixRecord);
        return pixDTO;
    }

}
