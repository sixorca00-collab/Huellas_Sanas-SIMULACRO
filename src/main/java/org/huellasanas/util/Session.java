package org.huellasanas.util;


import org.huellasanas.models.Cliente;
import org.huellasanas.models.Veterinario;

public class Session {

    private static Cliente clienteActual;
    private static Veterinario veterinarioActual;

    public static void loginCliente(Cliente cliente) {
        clienteActual = cliente;
        veterinarioActual = null;
    }

    public static void loginVeterinario(Veterinario vet) {
        veterinarioActual = vet;
        clienteActual = null;
    }

    public static Cliente getCliente() {
        return clienteActual;
    }

    public static Veterinario getVeterinario() {
        return veterinarioActual;
    }

    public static boolean esCliente() {
        return clienteActual != null;
    }

    public static boolean esVeterinario() {
        return veterinarioActual != null;
    }

    public static void logout() {
        clienteActual = null;
        veterinarioActual = null;
    }
}