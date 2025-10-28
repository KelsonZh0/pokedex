package br.com.fiap.bo;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.to.PokemonTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonBO {
    private static PokemonDAO pokemonDAO;

    public ArrayList<PokemonTO> findAll() {
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.findAll();
    }

    public PokemonTO findByCodigo(Long codigo) {
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.findByCodigo(codigo);
    }

    public PokemonTO save(PokemonTO pokemon){
        pokemonDAO = new PokemonDAO();
        // Lógica de negócio pode ser adicionada aqui
        if (pokemon.getDataDeCaptura().isAfter(LocalDate.now())){
            return null;
        }
        return pokemonDAO.save(pokemon);
    }

    public static boolean delete(Long codigo){
    pokemonDAO = new PokemonDAO();
    return pokemonDAO.delete(codigo);
    }

    public PokemonTO update(PokemonTO pokemon){
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.update(pokemon);
    }

}
