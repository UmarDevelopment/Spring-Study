package me.umar.services;

import me.umar.models.cleintsystem.Client;
import me.umar.models.cleintsystem.ClientForSearch;
import me.umar.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    public List<Client> findByName(String name){
        return clientRepository.findByNameLike(name);
    }

    public List<Client> findByAny(ClientForSearch client){
        return clientRepository.findByNameLikeAndSurnameLikeAndAgeBetween(
                "%"+client.getName()+"%",
                "%"+client.getSurname()+"%",
                client.getMinAge(),
                client.getMaxAge()
        );
    }

    public void save(Client client){
        clientRepository.save(client);
    }
}
