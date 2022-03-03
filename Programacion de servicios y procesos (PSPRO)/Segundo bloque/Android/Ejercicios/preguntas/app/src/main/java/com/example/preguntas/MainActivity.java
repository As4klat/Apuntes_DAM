package com.example.preguntas;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.preguntas.BaseDatos.SQLiteBD;
import com.example.preguntas.Clases.Pregunta;
import com.example.preguntas.Clases.Respuesta;
import com.example.preguntas.Clases.Usuario;
import com.example.preguntas.Controller.ControladorPreguntas;
import com.example.preguntas.Controller.ControladorUsuario;
import com.example.preguntas.Controller.LoginStatus;
import com.example.preguntas.fragments.ComenzarJuegoFragment;
import com.example.preguntas.fragments.ConfigFragment;
import com.example.preguntas.fragments.InicioFragment;
import com.example.preguntas.fragments.LoginFragment;
import com.example.preguntas.fragments.PersonalFragment;
import com.example.preguntas.fragments.RegisterFragment;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,
        DrawerLayout.DrawerListener {

    private DrawerLayout drawerLayout;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        MenuItem menuItem = navigationView.getMenu().getItem(0);
        onNavigationItemSelected(menuItem);
        menuItem.setChecked(true);

        menuItem = navigationView.getMenu().findItem(R.id.nav_personal);
        if(!LoginStatus.logeado()){
            menuItem.setVisible(false);
        }
        else{
            menuItem.setVisible(true);
        }

        drawerLayout.addDrawerListener(this);
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        int title;
        Fragment fragment;
        switch (menuItem.getItemId()) {
            case R.id.nav_inicio:
                title = R.string.inicio_string;
                fragment = InicioFragment.newInstance(getString(title));
                break;
            case R.id.nav_comenzarJuego:
                title = R.string.comenzarJuego_string;
                ControladorPreguntas.getInstance(getApplicationContext()).preCargarDatos();
                fragment = ComenzarJuegoFragment.newInstance(getString(title));
                break;
            case R.id.nav_config:
                title = R.string.config_string;
                fragment = ConfigFragment.newInstance(getString(title));
                break;
            case R.id.nav_login:
                title = R.string.login_string;
                fragment = LoginFragment.newInstance(getString(title));
                break;
            case R.id.nav_register:
                title = R.string.register_string;
                fragment = RegisterFragment.newInstance(getString(title));
                break;
            case R.id.nav_personal:
                title = R.string.personal_string;
                fragment = PersonalFragment.newInstance(getString(title));
                break;
            case R.id.nav_desconectarse:
                LoginStatus.desconectar();
                title = R.string.inicio_string;
                fragment = InicioFragment.newInstance(getString(title));
                break;
            default:
                throw new IllegalArgumentException("menu option not implemented!!");
        }
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                .replace(R.id.home_content, fragment)
                .commit();
        setTitle(getString(title));
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onDrawerSlide(@NonNull View view, float v) {
        //cambio en la posición del drawer
    }

    @Override
    public void onDrawerOpened(@NonNull View view) {
        //el drawer se ha abierto completamente
    }

    @Override
    public void onDrawerClosed(@NonNull View view) {
        //el drawer se ha cerrado completamente
    }

    @Override
    public void onDrawerStateChanged(int i) {
        //cambio de estado, puede ser STATE_IDLE, STATE_DRAGGING or STATE_SETTLING
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        MenuItem navPersonal = navigationView.getMenu().findItem(R.id.nav_personal);
        MenuItem navLogin = navigationView.getMenu().findItem(R.id.nav_login);
        MenuItem navRegister = navigationView.getMenu().findItem(R.id.nav_register);
        MenuItem navDesconectar = navigationView.getMenu().findItem(R.id.nav_desconectarse);
        if(!LoginStatus.logeado()){
            navPersonal.setVisible(false);
            navDesconectar.setVisible(false);
            navLogin.setVisible(true);
            navRegister.setVisible(true);
        }
        else{
            navPersonal.setVisible(true);
            navDesconectar.setVisible(true);
            navLogin.setVisible(false);
            navRegister.setVisible(false);
        }
    }

    public void loginToRegister(View view) {
        Fragment fragment = RegisterFragment.newInstance(getString(R.string.register_string));
        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit)
                .replace(R.id.home_content, fragment)
                .commit();
    }
}