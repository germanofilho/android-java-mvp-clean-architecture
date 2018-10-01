package com.germanofilho.desafio.car.presentation.view.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.germanofilho.desafio.R;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.util.Animation;
import com.germanofilho.desafio.core.util.FormatNumber;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {

    private List<Car> mCar;
    private Consumer<Car> onCarClicked;
    private Consumer<Car> onCartClicked;
    private Context mContext;

    public CarAdapter(Context context, List<Car> car) {
        mCar = car;
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.txt_title_car)
        TextView mTxtTitleCar;

        @BindView(R.id.txt_brand)
        TextView mTxtBrand;

        @BindView(R.id.txt_price)
        TextView mTxtPrice;

        @BindView(R.id.img_car)
        ImageView mImgCar;

        @BindView(R.id.cardview_car)
        CardView mCardViewCar;

        @BindView(R.id.btn_add_cart)
        ImageView mBtnAddCart;

        Car item;

        public ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        public void setData(final Car item) {
            this.item = item;
            mTxtTitleCar.setText(item.getNome());
            mTxtBrand.setText(item.getMarca());
            mTxtPrice.setText(mContext.getString(R.string.total_value, FormatNumber.set(item.getPreco())));

            Picasso.get()
                    .load(item.getImagem())
                    .placeholder(R.drawable.placeholder)
                    .into(mImgCar);

            Animation.fadeIn(mCardViewCar);

            mCardViewCar.setOnClickListener(view -> {
                try {
                    onCarClicked.accept(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });

            mBtnAddCart.setOnClickListener(view -> {
                try {
                    onCartClicked.accept(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_car, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(mCar.get(position));
    }

    @Override
    public int getItemCount() {
        return mCar.size();
    }

    public void setOnCarClicked(Consumer<Car> onCarClicked) {
        this.onCarClicked = onCarClicked;
    }

    public void setOnCartClicked(Consumer<Car> onCartClicked) {
        this.onCartClicked = onCartClicked;
    }
}