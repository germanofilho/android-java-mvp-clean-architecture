package com.germanofilho.desafio.core.model.domain.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by germano on 22/06/18.
 * germanof16@gmail.com
 */

public class Car implements Parcelable {
    private long id;
    private String nome;
    private String descricao;
    private String marca;
    private int quantidade;
    private double preco;
    private String imagem;
    private int qtdCart;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public String getImagem() {
        return imagem;
    }

    public String getMarca() {
        return marca;
    }

    public int getqtdCart() {
        return qtdCart;
    }

    public void setQtdCart(int qtdCart) {
        this.qtdCart = qtdCart;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(this.id);
        dest.writeString(this.nome);
        dest.writeString(this.descricao);
        dest.writeInt(this.quantidade);
        dest.writeInt(this.qtdCart);
        dest.writeDouble(this.preco);
        dest.writeString(this.imagem);
        dest.writeString(this.marca);
    }

    public Car() {
    }

    protected Car(Parcel in) {
        this.id = in.readLong();
        this.nome = in.readString();
        this.descricao = in.readString();
        this.quantidade = in.readInt();
        this.qtdCart = in.readInt();
        this.preco = in.readDouble();
        this.imagem = in.readString();
        this.marca = in.readString();
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel source) {
            return new Car(source);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
