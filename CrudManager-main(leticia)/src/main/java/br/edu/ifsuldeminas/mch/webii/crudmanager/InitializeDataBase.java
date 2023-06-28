package br.edu.ifsuldeminas.mch.webii.crudmanager;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Time;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.JogadorRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.dao.TimeRepository;
import br.edu.ifsuldeminas.mch.webii.crudmanager.model.Jogador;
@Component
@Transactional
public class InitializeDataBase implements CommandLineRunner{
    
    @Autowired
    private TimeRepository timeRepository;
    @Autowired
    private JogadorRepository jogadorRepository;
    
    @Override
    public void run(String... args) throws Exception {
        Time Time1 = new Time();
        Time1 .setNome("Atlético Mineiro");
        Time1 .setLiga("Libertadores");
        Time1 .setTecnico("Luiz Felipe Scolari");
        Time1 .setTitulos(true);
        
        Time Time2 = new Time();
        Time2.setNome("Palmeiras");
        Time2.setLiga("Libertadores");
        Time2.setTecnico("Abel Ferreira");
        Time2.setTitulos(true);
        
        Time Time3 = new Time();
        Time3.setNome("Vasco da Gama");
        Time3.setLiga("Brasileiro");
        Time3.setTecnico("Maurício Barbieri");
        Time3.setTitulos(true);
        
     Jogador jogador1 = new Jogador();
     jogador1.setNome("Hulk Paraíba"); 
     jogador1.setNumberCamisa(7);
     jogador1.setCampeonato("Mineiro");
     jogador1.setPosicao("Atacante");
     jogador1.setTime(Time1);

     Jogador jogador2 = new Jogador();
     jogador2.setNome("Raphael Veiga"); 
     jogador2.setNumberCamisa(23);
     jogador2.setCampeonato("Paulista");
     jogador2.setPosicao("Meia");
     jogador2.setTime(Time2);
     
     Jogador jogador3 = new Jogador();
     jogador3.setNome("Gabriel Pec"); 
     jogador3.setNumberCamisa(11);
     jogador3.setCampeonato("Carioca");
     jogador3.setPosicao("Atacante");
     jogador3.setTime(Time3);



        timeRepository.save(Time1);
        timeRepository.save(Time2);
        timeRepository.save(Time3);
        jogadorRepository.save(jogador1);
        jogadorRepository.save(jogador2);
        jogadorRepository.save(jogador3);
        
        
        
     }
    
}