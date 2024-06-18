package me.umar;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("me.umar")
public class SpringConfig {

    @Bean
    public RockMusic rockMusic(){
        return new RockMusic();
    }

    @Bean
    public ClassicalMusic classicMusic(){
        return new ClassicalMusic();
    }

    @Bean
    public CountryMusic countryMusic(){
        return new CountryMusic();
    }

    @Bean
    MusicList musicList(){
        MusicList musicList = new MusicList();
        musicList
                .addMusic(classicMusic())
                .addMusic(rockMusic())
                .addMusic(countryMusic())
        ;
        return musicList;
    }

    @Bean
    public MusicPlayer musicPlayer(){
        return new MusicPlayer(musicList());
    }
}
