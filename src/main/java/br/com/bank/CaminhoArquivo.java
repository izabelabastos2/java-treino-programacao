package br.com.bank;

import java.nio.file.Path;
import java.nio.file.Paths;

public class CaminhoArquivo {

    private Path diretorio;

    private Path arquivo;

    private CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }

    public static CaminhoArquivo getInstance(Integer id) {

        String b = "/tmp/";
        String d = null;
        String arquivo = null;
        int diretorio = 1;

        if (id > 1000) {
            diretorio = id / 1000;

            if (id % 1000 == 0) {
                d = b + diretorio;
                arquivo = d + "/" + id;
            } else {
                diretorio = diretorio + 1;
                d = b + diretorio;
                arquivo = d + "/" + id;
            }

        } else {
            d = b + diretorio;
            arquivo = d + "/" + id;
        }

        return new CaminhoArquivo(Paths.get(d), Paths.get(arquivo));

    }

}
