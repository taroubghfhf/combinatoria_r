package org.example;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void combinar(int n, int k, int inicio, List<Integer> actual, List<List<Integer>> resultado) {
        if (actual.size() == k) {
            resultado.add(new ArrayList<>(actual)); // Copiar la combinación actual
            return;
        }

        for (int i = inicio; i <= n; i++) {
            actual.add(i);                      // Elegimos el número i
            combinar(n, k, i + 1, actual, resultado); // Llamada recursiva
            actual.remove(actual.size() - 1);   // Backtracking: quitamos el último
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        List<List<Integer>> combinaciones = new ArrayList<>();
        combinar(n, k, 1, new ArrayList<>(), combinaciones);

        System.out.println("Combinaciones de " + k + " elementos de un conjunto de " + n + ":");
        for (List<Integer> combinacion : combinaciones) {
            System.out.println(combinacion);
        }
    }
}