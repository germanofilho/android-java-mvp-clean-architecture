package com.germanofilho.desafio.checkout.presentation.view.ui.adapter;

/**
 * Created by germano on 27/06/18.
 * germanof16@gmail.com
 */

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.germanofilho.desafio.R;
import com.germanofilho.desafio.core.model.domain.entity.Car;
import com.germanofilho.desafio.core.util.Animation;
import com.germanofilho.desafio.core.util.FormatNumber;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.functions.Consumer;

/**
 * Created by germano on 23/06/18.
 * germanof16@gmail.com
 */

public class CheckoutAdapter extends RecyclerView.Adapter<CheckoutAdapter.ViewHolder> {

    private List<Car> mCar;
    private Consumer<Car> onDeleteClicked;
    private Context mContext;

    public CheckoutAdapter(Context context, List<Car> car) {
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

        @BindView(R.id.txt_quantity)
        TextView mTxtQuantity;

        @BindView(R.id.img_car)
        ImageView mImgCar;

        @BindView(R.id.cardview_checkout)
        CardView mCardViewCheckout;

        @BindView(R.id.btn_delete)
        ImageView mBtnDelete;

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
            mTxtQuantity.setText(mContext.getString(R.string.quantity_buy, item.getqtdCart()));

            Picasso.get()
                    .load(item.getImagem())
                    .placeholder(R.drawable.placeholder)
                    .into(mImgCar);

            Animation.fadeIn(mCardViewCheckout);

            mBtnDelete.setOnClickListener(view -> {
                try {
                    onDeleteClicked.accept(item);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_checkout, parent, false);
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

    public void setOnDeleteClicked(Consumer<Car> onCartClicked) {
        this.onDeleteClicked = onCartClicked;
    }
}