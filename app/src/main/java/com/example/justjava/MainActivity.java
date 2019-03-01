package com.example.justjava;

import java.text.NumberFormat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.justjava.R;

/**
 * This app displays an order form to order coffee
 */

public class MainActivity extends AppCompatActivity {
int x = 0 , numberOfCoffees = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        numberOfCoffees = ++x;
        if (x > 0) {
            displayQuantity(numberOfCoffees);
        } else {
            numberOfCoffees = 0;
            displayQuantity(numberOfCoffees);
        }
    }
    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {

            numberOfCoffees = --x;
            if(x>=0)
            {   displayQuantity(numberOfCoffees);
        }
        else x=0;
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        String priceMessage = CreateOrderSummary(price);
        numberOfCoffees = x;
        if (x >= 0) {
            displayQuantity(numberOfCoffees);
            int t =x*5 ;

            displayMessage(priceMessage);
        }
    }

    private String CreateOrderSummary(int price)
    {
        String priceMessage = "Shalabh Bansal \n" ;
        priceMessage=priceMessage + "$"+ price ;
    priceMessage = priceMessage +"\nThank U!";
    return priceMessage;
    }
    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private int calculatePrice()
    {
        int price = x*5 ;
        return price ;

    }
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
}
