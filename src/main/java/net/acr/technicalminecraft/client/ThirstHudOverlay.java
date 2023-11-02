package net.acr.technicalminecraft.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.acr.technicalminecraft.TechnicalMinecraft;
import net.minecraft.client.gui.GuiComponent;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class ThirstHudOverlay {
    private static final ResourceLocation FILLED_THIRST = new ResourceLocation(TechnicalMinecraft.MOD_ID,
            "textures/thirst/filled_thirst.png");

    private static final ResourceLocation HALF_THIRST = new ResourceLocation(TechnicalMinecraft.MOD_ID,
            "textures/thirst/half_thirst.png");

    private static final ResourceLocation EMPTY_THIRST = new ResourceLocation(TechnicalMinecraft.MOD_ID,
            "textures/thirst/empty_thirst.png");

    public static final IGuiOverlay HUD_THIRST = (((gui, poseStack, partialTick, width, height) -> {
        int x = width / 2;
        int y = height;

        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_THIRST);

        for(int i = 0; i < 10; i++) {
            GuiComponent.blit(poseStack, x - 94 + (i * 9), y - 54, 0, 0, 15, 15,
                    15, 15);
        }

        RenderSystem.setShaderTexture(0, FILLED_THIRST);

        for(int i = 0; i < 10; i++) {
            if(ClientThistData.getPlayerThirst() > i) {
                GuiComponent.blit(poseStack, x - 94 + (i * 9), y - 54, 0, 0, 15, 15,
                        15, 15);
            }
            else {
                break;
            }
        }
    }));
}