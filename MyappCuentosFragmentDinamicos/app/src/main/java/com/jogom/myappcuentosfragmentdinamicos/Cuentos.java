package com.jogom.myappcuentosfragmentdinamicos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class Cuentos extends AppCompatActivity {

    private TabLayout tabLayout;
    private Fragment fragment1, fragment2, fragment3, fragment4, fragment5;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuentos);

        tabLayout = findViewById(R.id.tlId);
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 4"));
        tabLayout.addTab(tabLayout.newTab().setText("Cuento 5"));

        fragment1 = new CuentoUno();
        fragment2 = new CuentoDos();
        fragment3 = new CuentoTres();
        fragment4 = new CuentoCuatro();
        fragment5 = new CuentoCinco();

        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment2).hide(fragment2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment3).hide(fragment3).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment4).hide(fragment4).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.frlContenedor, fragment5).hide(fragment5).commit();

        this.accionTabLayout();
    }

    private void accionTabLayout() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                transaction = getSupportFragmentManager().beginTransaction();
                switch (tab.getPosition()) {
                    case 0:
                        if(fragment1.isAdded()){
                            transaction.show(fragment1).hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment5);
                        }
                        else{
                            transaction.hide(fragment2).hide(fragment3).hide(fragment4).hide(fragment5).add(R.id.frlContenedor,fragment1).addToBackStack(null);
                        }
                        break;
                    case 1:
                        if(fragment2.isAdded()){
                            transaction.show(fragment2).hide(fragment1).hide(fragment3).hide(fragment4).hide(fragment5);
                        }
                        else{
                            transaction.hide(fragment1).hide(fragment3).hide(fragment4).hide(fragment5).add(R.id.frlContenedor,fragment2).addToBackStack(null);
                        }
                        break;
                    case 2:
                        if(fragment3.isAdded()){
                            transaction.show(fragment3).hide(fragment1).hide(fragment2).hide(fragment4).hide(fragment5);
                        }
                        else{
                            transaction.hide(fragment1).hide(fragment2).hide(fragment4).hide(fragment5).add(R.id.frlContenedor,fragment3).addToBackStack(null);
                        }
                        break;
                    case 3:
                        if(fragment4.isAdded()){
                            transaction.show(fragment4).hide(fragment1).hide(fragment2).hide(fragment3).hide(fragment5);
                        }
                        else{
                            transaction.hide(fragment1).hide(fragment2).hide(fragment3).hide(fragment5).add(R.id.frlContenedor,fragment4).addToBackStack(null);
                        }
                        break;
                    case 4:
                        if (fragment5.isAdded()){
                            transaction.show(fragment5).hide(fragment1).hide(fragment2).hide(fragment3).hide(fragment4);
                        }
                        else{
                            transaction.hide(fragment1).hide(fragment2).hide(fragment3).hide(fragment4).add(R.id.frlContenedor,fragment5).addToBackStack(null);
                        }
                        break;
                }
                transaction.commit();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}