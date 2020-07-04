package com.mohamedsobhy.foodapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.food_item.view.*

class MainActivity : AppCompatActivity() {

    private var listOfFood = ArrayList<Food>()
    private var adapter:FoodAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFood()

        adapter= FoodAdapter(listOfFood , this)
        listViewFood.adapter = adapter
    }

    private fun loadFood(){

        listOfFood.add(Food("Nescafè" , "In 1929, Nestlé was challenged to help preserve the surplus coffee beans in Brazil that resulted from the Wall Street Crash. And Nestlé accepted the challenge." +
                "Our coffee specialist, Max Morgenthaler, was on a mission to create a delicious cup of coffee simply by adding water. Max and his team worked hard to find a new way to make instant coffee that would retain the coffee’s natural flavour. In 1938, they found the answer, and NESCAFÉ was born. Named by using the first three letters in Nestlé and suffixing it with ‘café’, NESCAFÉ became the new name in coffee." ,
        R.drawable.nescafe))

        listOfFood.add(Food("Coffee" , "Coffee is a brewed drink prepared from roasted coffee beans, the seeds of berries from certain Coffea species. ... Roasted beans are ground and then brewed with near-boiling water to produce the beverage known as coffee." ,
            R.drawable.coffee))

        listOfFood.add(Food("Smoothie" , "Blended, chilled, sometimes sweetened beverage made from fresh or frozen fruit or vegetables. • Many smoothies include fruit juice, honey or contain syrup. • They have a milkshake-like consistency which is thicker than slush drinks." ,
            R.drawable.drink))

        listOfFood.add(Food("Green Tea" , "Green tea is a type of tea that is made from Camellia sinensis leaves and buds that have not undergone the same withering and oxidation process used to make oolong teas and black teas. Green tea originated in China, but its production and manufacture has spread to other countries in East Asia." ,
            R.drawable.tea))

        listOfFood.add(Food("Lemon Mint" , "My take on limonada: Mediterranean-style mint lemonade as they make it in Egypt. Intense with flavor, extra frothy, and extremely refreshing! There is a tiny trick involved that makes all the difference…" ,
            R.drawable.limon))

        listOfFood.add(Food("Cheese Cake" , "As much as I love cheesecake, I’ve never published a classic cheesecake recipe. There’s always been peanut butter, sprinkles, blueberry swirls, Snickers cheesecake, pumpkin, lemon, red velvet, or Nutella. That’s a lot of cheesecake recipes without a single nod to where it all originates: classic cheesecake." ,
            R.drawable.cheese_cake))

        listOfFood.add(Food("Burger" , "A hamburger (also burger for short) is a sandwich consisting of one or more cooked patties of ground meat, usually beef, placed inside a sliced bread roll or bun. The patty may be pan fried, grilled, smoked or flame broiled. ... There are many international and regional variations of the hamburger." ,
            R.drawable.burger))

        listOfFood.add(Food("Fries" , "French fries or simply fries or chips, are pieces of potato that have been deep-fried. ... These are deep-fried, very thin, salted slices of potato that are usually served at room temperature. French fries have numerous variants, from thick-cut to shoestring, crinkle, curly and many other names" ,
            R.drawable.fries))

        listOfFood.add(Food("Fried Chicken" , "When it comes to chicken there just isn't anything more delicious than a juicy, crusty piece of finger-licking... jump to recipe icon. Jump to Recipe." ,
            R.drawable.fried_chicken))

        listOfFood.add(Food("Pasta" , "Pasta is the Italian designation or name given to a type of starchy noodle or dumpling food or dish typically made from grain flour, commonly wheat, mixed into a paste or dough, usually with water or eggs, and formed or cut into sheets or other shapes." ,
            R.drawable.pasta))

    }

    inner class FoodAdapter : BaseAdapter{

        var context: Context ?=null
        var listOfFoodLocal = ArrayList<Food>()

        constructor(listOfFood : ArrayList<Food> , context: Context){
            listOfFoodLocal = listOfFood
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val food = listOfFoodLocal[position]
            var inflater= context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val foodView = inflater.inflate(R.layout.food_item , null)

            foodView.coffeeName.text = food.name

            foodView.coffeeDiscription.text = food.description

            foodView.coffeeImage.setImageResource(food.images!!)

            foodView.delete_imageView.setOnClickListener{
                delete(position)
            }

            foodView.readMore.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java).apply {
                    putExtra("name", food.name!!)
                    putExtra("description", food.description!!)
                    putExtra("image", food.images!!)
                }
                context!!.startActivity(intent)
            }

            return foodView
        }

        override fun getItem(position: Int): Any {
            return listOfFoodLocal[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFoodLocal.size
        }

    }

    private fun delete(index : Int){
        listOfFood.removeAt(index)
        adapter!!.notifyDataSetChanged()
    }

}