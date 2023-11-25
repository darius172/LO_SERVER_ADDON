package com.example.addon.mixins;

import com.example.addon.modules.Bot_Mode_Module;
import meteordevelopment.meteorclient.MeteorClient;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static java.lang.Math.round;

@Mixin(PlayerEntity.class)
public class PlayerTickMixin {
    @Inject(at = @At("TAIL"), method = "tick")
    private void Rounding(CallbackInfo info) throws InterruptedException {
        Entity player = MeteorClient.mc.player;
        if(MinecraftClient.getInstance().player.hasVehicle()){
            player = MeteorClient.mc.player.getVehicle();
        }
        //the normal coordonates of the player
        double rawx = player.getX();
        double rawy = player.getY();
        double rawz = player.getZ();

        //we round the coordonates in the math below
        double xR = round(rawx*100);
        //double yR = round(rawy*100);
        double zR = round(rawz*100);
        double x = xR/100;
        //double y = yR/100;
        double z = zR/100;
        if (Modules.get().isActive(Bot_Mode_Module.class)){


            //now we set the player coordonates to the rounded x, y, z
            player.setPosition(x,rawy,z);

            //this should bypass th only bot plugin made by liveoverflow

        }


    }
}
