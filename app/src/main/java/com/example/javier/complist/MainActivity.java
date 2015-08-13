package com.example.javier.complist;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.javier.complist.adapter.NavDrawerAdapter;
import com.example.javier.complist.componentes.NavDrawerItem;
import com.example.javier.complist.componentes.NavMenuItem;
import com.example.javier.complist.componentes.NavMenuSection;


public class MainActivity extends ActionBarActivity {


    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView NavList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*********************toolbar

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        NavList = (ListView) findViewById(R.id.lista);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setTitle("Bicimetro");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Click",
                        Toast.LENGTH_SHORT).show();
            }
        });


        mDrawerToggle = new ActionBarDrawerToggle(
                this, mDrawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
        ) {

            /**
             * Called when a drawer has settled in a completely closed state.
             */
            public void onDrawerClosed(View view) {

                getSupportActionBar().setTitle("Bicimetro");
            }

            /**
             * Called when a drawer has settled in a completely open state.
             */
            public void onDrawerOpened(View drawerView) {
                ActivityCompat.invalidateOptionsMenu(MainActivity.this);
            }
        };



        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setSupportActionBar(toolbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        // MENU DINAMICO - menu izquierdo desplazable hacÃƒÂ­a la derecha
        creacionMenuDinamico();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inf  late the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }


    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }



    public void creacionMenuDinamico() {
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.ppal_drawer_layout);
//		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
//				GravityCompat.START);

        NavDrawerItem[] menu = new NavDrawerItem[] {
                //Informacion de interes
                NavMenuSection.create(0, ""),
//                NavMenuItem.create(MENU_INSP,
//                        getResources().getString(R.string.buscar),
//                        null, false, 0, MainActivity.this),
//                NavMenuItem.create(MENU_INSP,
//                        getResources().getString(R.string.oficinas_turismo),
//                        null, false, 0, MainActivity.this),
//                NavMenuItem.create(MENU_INSP,
//                        getResources().getString(R.string.telefonos),
//                        null, false, 0, MainActivity.this),
//                NavMenuItem.create(MENU_INSP,
//                        getResources().getString(R.string.vinos_tapas),
//                        null, false, 0, MainActivity.this),
//                NavMenuItem.create(MENU_INSP,
//                        getResources().getString(R.string.ocio_nocturno),
//                        null, false, 0, MainActivity.this),
//
//                //Redes sociales
//                NavMenuSection.create(REDES_SOCIALES, "REDES SOCIALES"),
//                NavMenuItem.create(REDES_SOCIALES,
//                        "Ir a facebook",
//                        "ic_facebook", false, 0, MainActivity.this),
//                NavMenuItem.create(REDES_SOCIALES,
//                        "Ir a Twitter", "ic_twiter",
//                        false, 0, MainActivity.this),
//                NavMenuItem.create(REDES_SOCIALES,
//                        "Ir a youtube","ic_youtube",
//                        false, 0, MainActivity.this),
                NavMenuItem.create(0, "Ir a Blog Info.Valladolid",
                        "ic_blogger", false, 0, MainActivity.this),

        };



        NavList.setAdapter(new NavDrawerAdapter(MainActivity.this,
                R.layout.drawer_item, menu, MainActivity.this));

        //Mantener seleccionad la opcion
//		navList.setAdapter(new ArrayAdapter<String>(getSupportActionBar().getThemedContext(),
//			    (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) ?
//			    android.R.layout.simple_list_item_activated_1 :
//			    android.R.layout.simple_list_item_1, lista));

        //NavList.setOnItemClickListener(new DrawerItemClickListener());
    }
}
