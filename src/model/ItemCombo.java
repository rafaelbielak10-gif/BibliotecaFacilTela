package model;

public class ItemCombo {

    private int id;
    private String descricao;


    public ItemCombo(int id, String descricao){

        this.id = id;
        this.descricao = descricao;

    }


    public int getId(){

        return id;

    }


    public String getDescricao(){

        return descricao;

    }


    @Override
    public String toString(){

        return descricao;

    }

}