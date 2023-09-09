package com.uco.taller.dispensadora.dominio;


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Dispensadora {
    private List<Snack> snacks;

    public Dispensadora() {
        snacks = new ArrayList<>();
    }

    public void agregarSnack (String nombre,float precio, int cantidadDisponible, String codigo){
        if (snacks.size() <12) {
            Snack snackAAgregar= new Snack(nombre, precio, cantidadDisponible, codigo);
            snacks.add(snackAAgregar);
        } else {
            System.out.println("El producto no pudo ser añadido exitosamente. ");
        }

    }

    private Snack buscarSnackPorCodigo(String codigoAbuscar) {
        for (Snack snack : snacks) {
            if (snack.getCodigo().equalsIgnoreCase(codigoAbuscar)) {
                return snack;
            }
        }
        return null;
    }


    public void quitarSnackPorcodigo(String codigo){
        Snack snack = buscarSnackPorCodigo(codigo);
        if (snack !=null) {
            snacks.remove(snack);
        } else {
            System.out.println("El producto no se pudo eliminar");
        }
    }
    public void sacarUnidadPorNombre(String nombre) {
        Snack snack = (Snack) buscarPorNombre(nombre);
        if (snack != null) {
            snack.reducirCantidad(1);
        } else {
            System.out.println("Snack no encontrado.");
        }
    }

    private List<Snack> buscarPorNombre(String nombreABuscar) {
        return this.snacks.stream()
                .filter(snack -> snack.getNombre().equalsIgnoreCase(nombreABuscar))
                .toList();
    }

    public void aumentarCantidadPorCodigoOxNombre(String codigoONombre, int cantidad) {
        Snack snack = buscarSnackPorCodigoONombre(codigoONombre);
        if (snack != null) {
            snack.aumentarCantidad(cantidad);
            System.out.println("Se agregaron " + cantidad + " unidades de " + snack.getNombre() + ".");
        } else {
            System.out.println("Snack no encontrado.");
        }
    }

    private Snack buscarSnackPorCodigoONombre(String codigoONombre) {
        for (Snack snack : snacks) {
            if (snack.getCodigo().equalsIgnoreCase(codigoONombre) || snack.getNombre().equalsIgnoreCase(codigoONombre)) {
                return snack;
            }
        }
        return null;
    }
    public void quitarSnack() {
        if (!snacks.isEmpty()) {
            snacks.remove(snacks.size() - 1); // Elimina el último snack de la lista
            System.out.println("Se ha retirado el último snack de la máquina dispensadora.");
        } else {
            System.out.println("La máquina dispensadora está vacía.");
        }
    }
    public int cantidadDisponiblePorCodigo(String codigo) {
        Snack snack = buscarSnackPorCodigo(codigo);
        if (snack != null) {
            return snack.getCantidadDisponible();
        }
        return -1; // Retorna -1 si el snack no se encuentra.
    }
    public List<String> obtenerSnacksAgotados() {
        List<String> agotados = new ArrayList<>();
        for (Snack snack : snacks) {
            if (snack.getCantidadDisponible() == 0) {
                agotados.add(snack.getNombre());
            }
        }
        return agotados;
    }

    public List<String> obtenerNombresYCantidadSnacks() {
        List<String> nombresYCantidades = new ArrayList<>();
        for (Snack snack : snacks) {
            nombresYCantidades.add(snack.getNombre() + ": " + snack.getCantidadDisponible());
        }
        return nombresYCantidades;
    }

    public void ordenarPorValorDescendente() {
        Collections.sort(snacks, new Comparator<Snack>() {
            @Override
            public int compare(Snack snack1, Snack snack2) {
                return Double.compare(snack2.getPrecio(), snack1.getPrecio());
            }
        });
    }

    public void ordenarPorCantidadAscendente() {
        Collections.sort(snacks, new Comparator<Snack>() {
            @Override
            public int compare(Snack snack1, Snack snack2) {
                return Integer.compare(snack1.getCantidadDisponible(), snack2.getCantidadDisponible());
            }
        });
    }


    public int cantidadDisponibles(String codigo){
        Snack snack = buscarSnackPorCodigo(codigo);
        if (snack != null) {
            return snack.getCantidadDisponible();
        }
        return -1;

    }
}


