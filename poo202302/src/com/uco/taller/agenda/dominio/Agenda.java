package com.uco.taller.agenda.dominio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private static final int CAPACIDAD_AGENDA = 50;
    private List<Contacto> contactos;

    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public void crearContacto(String nombre, String apellido, long celular) {
        Contacto c = this.buscarPorCelular(celular);

        if (this.contactos.size() < CAPACIDAD_AGENDA && c == null) {
            Contacto contactoAAgregar = new Contacto(nombre, apellido, celular);
            this.contactos.add(contactoAAgregar);
        } else {
            System.out.println("El contacto no se pudo crear.");
        }
    }

    public boolean eliminarContacto(long celularAEliminar) {
        Contacto contactoExistente = this.buscarPorCelular(celularAEliminar);

        if (contactoExistente != null) {
            this.contactos.remove(contactoExistente);
            return true;
        }

        return false;
    }

    public List<Contacto> buscarPorNombre(String nombreABuscar) {
        return this.contactos.stream()
                .filter(contact -> contact.getNombre().equalsIgnoreCase(nombreABuscar))
                .toList();
    }

    public List<Contacto> buscarPorApellido(String apellidoABuscar) {
        List<Contacto> contactosPorApellido = new ArrayList<>();

        for (Contacto contacto : this.contactos) {
            if (contacto.getApellido().equalsIgnoreCase(apellidoABuscar)) {
                contactosPorApellido.add(contacto);
            }
        }

        return contactosPorApellido;
    }

    public Contacto buscarPorCelular(long celularABuscar) {
        return this.contactos.stream()
                .filter(contacto -> contacto.getCelular() == celularABuscar)
                .findFirst().orElse(null);
    }

    public void cambiarCelular(long celularActual, long nuevoCelular) {
        Contacto contactoExistente = this.buscarPorCelular(celularActual);

        if (contactoExistente != null) {
            contactoExistente.celular = nuevoCelular;
        }
    }
        public List<Contacto> ordenarAlfabeticamente() {
        this.contactos.sort(
                Comparator.comparing(Contacto::getNombre)
                        .thenComparing(Contacto::getApellido)
        );
        return this.contactos;
}
}
