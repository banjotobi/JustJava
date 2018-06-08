    package ng.edu.oouagoiwoye.justjava;

/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

    //package com.example.android.justjava;



    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.view.View;
    import android.widget.TextView;

    import java.text.NumberFormat;

    /**
     * This app displays an order form to order coffee.
     */
    public class MainActivity extends AppCompatActivity {

        TextView quantityTextView;
        public int perCup = 10;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        }





        /**
         * This method is called when the order button is clicked.
         */
        public void submitOrder(View view) {
            String old = quantityTextView.getText().toString();
            int $quantity = Integer.parseInt(old);

            int numberOfCoffes = $quantity;

            int price =  calculatePrice(numberOfCoffes, perCup);
            String priceMessage = NumberFormat.getCurrencyInstance().format(price) + " for  "+ numberOfCoffes +" cups of Coffee \n" +
                    " Thank you for your patronage";
            //display(numberOfCoffes);
            //displayPrice(5 * numberOfCoffes);
            String message = createOrderSummary(numberOfCoffes, price);
            displayMessage(message);
        }


        public void increament(View view) {
            String old = quantityTextView.getText().toString();
            int $quantity = Integer.parseInt(old);
             int ne = $quantity  + 1;
            //quantityTextView.setText("" + ne);


            displayQuanity(ne);
            int price =  calculatePrice(ne, perCup);
            String priceMessage = NumberFormat.getCurrencyInstance().format(price) + " for  "+ ne +" cups of Coffee \n" +
                    " Thank you for your patronage";
            //display(numberOfCoffes);
            //displayPrice(5 * numberOfCoffes);
            String message = createOrderSummary(ne, price);
            displayMessage(message);
            //displayPrice(5 * ne );
        }

        public void decrement(View view) {
            String old = quantityTextView.getText().toString();
            int quantity = Integer.parseInt(old);
            int prev = quantity;
            int ne = 0;
            if (prev > 0)
            {
                ne = Integer.parseInt(old) - 1;
            }

           // quantityTextView.setText("" + ne);


            displayQuanity(ne);
            int price =  calculatePrice(ne, perCup);
            String priceMessage = NumberFormat.getCurrencyInstance().format(price) + " for  "+ ne +" cups of Coffee \n" +
                    " Thank you for your patronage";
            //display(numberOfCoffes);
            //displayPrice(5 * numberOfCoffes);
            String message = createOrderSummary(ne, price);
            displayMessage(message);

            //displayPrice(5 * ne );
        }

        /**
         * This method displays the given quantity value on the screen.
         */
        private void displayQuanity(int no) {
            TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
            quantityTextView.setText("" + no);
        }


        /**
         * This method displays the given price on the screen.
         */
        private void displayPrice(int number) {
            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);

            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }

        private void displayMessage(String message) {
            TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
            priceTextView.setText(message);
        }

        private int calculatePrice(int quantity, int perCup) {
            int price = quantity * perCup;
            return price;
        }


        private String createOrderSummary(int quantity, int price)
        {
            return "NAME: BANJO, Oluwatobi \n Quantity: "+quantity+"\n Total: "+NumberFormat.getCurrencyInstance().format(price);

        }
    }