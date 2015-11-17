package main;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

import serverimpl.ModifServerImpl;
import Interface.IModificadorDeStrings;

import impl.ClientModifImpl;

public class ModifStartClient extends ServerMainBase {

    private Scanner write;
    private Registry registry;
    private IModificadorDeStrings modif;
    private String operacoes;

    public ModifStartClient() {
        super(IModificadorDeStrings.class);
    }

    @Override
    public void doCustomRmiHandling() {

        menu();

        try {

            

            do {
                System.out.println("Digite sua Opção");
            operacoes = getWrite().nextLine();
                switch (operacoes) {

                    case "1":
                        System.out.print("Digite uma palavra ou frase: ");
                        String s = write.nextLine();
                        System.out.println("Frase original: " + s);
                        System.out.println("Frase invertida: " + getMod().reverterString(s));
                        break;
                    case "2":
                        System.out.print("Digite uma palavra ou frase: ");
                        s = write.nextLine();
                        System.out.println(getMod().contaVogais(s));
                        break;
                    default:
                        System.out.println("Opcao errada");
                        case"0":
                            System.out.println("Fechando");
                            break;
                }

            } while (!operacoes.equals("0"));
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private IModificadorDeStrings getMod() throws RemoteException, NotBoundException {
        if (modif == null) {
            modif = new ModifServerImpl();
            modif = (IModificadorDeStrings) getResgistry().lookup("modif");
        }
        return modif;
    }

    private Registry getResgistry() throws RemoteException {
        if (registry == null) {
            registry = LocateRegistry.getRegistry();
        }
        return registry;
    }

    private Scanner getWrite() {
        if (write == null) {
            write = new Scanner(System.in);
        }
        return write;
    }

    public void menu() {

        System.out.println("Sistema para analizar strings:");
        System.out.println("Escolha 1 para: Reverter a string");
        System.out.println("Escolha 2 para: Contar vogais da string");
        System.out.println("Escolha 0 para: Sair");
    }

    public void finalizaCalc() {
        String sim = "sim";
        System.out.println("Deseja finaliza a cálculadora: SIM ou NÃO ?");
        sim = getWrite().next();
        if (sim.equals("sim")) {
            System.out.println("Cáculadora finalizada....");
            System.exit(0);
        } else {
            doCustomRmiHandling();
        }
    }

    public void reiniciaCalc() {
        String sim = "sim";
        System.out.println("Deseja reiniciar a cálculadora: SIM ou NÃO ?");
        sim = getWrite().next();
        if (sim.equals("sim")) {
            doCustomRmiHandling();
        } else {
            System.out.println("Cáculadora finalizada....");
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new ModifStartClient();
    }

}
