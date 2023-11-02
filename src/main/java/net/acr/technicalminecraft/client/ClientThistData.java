package net.acr.technicalminecraft.client;

public class ClientThistData {
    private static int playerThirst;

    public static void set(int thirst) {
        ClientThistData.playerThirst = thirst;
    }

    public static int getPlayerThirst() {
        return playerThirst;
    }
}