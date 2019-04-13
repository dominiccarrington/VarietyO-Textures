/*
 * Copyright (C) 2019 Dominic Carrington
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.ragegamingpe.varietyotextures;

import com.ragegamingpe.varietyotextures.render.RenderWolf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.*;

@Mod(modid = VarietyOTextures.MOD_ID, name = VarietyOTextures.NAME, version = VarietyOTextures.VERSION, clientSideOnly = true)
public class VarietyOTextures
{
    public static final String MOD_ID = "varietyotextures";
    public static final String NAME = "Variety O' Textures";
    public static final String VERSION = "GRADLE:VERSION";

    @Mod.Instance
    public static VarietyOTextures instance;

    public static Logger logger;

    private static final Map<Type, List<ResourceLocation>> TEXTURES = new HashMap<>();

    private static final int WOLF_TAMED_COUNT = 6;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        TEXTURES.put(Type.WOLF_TAMED, getTextures("wolf/tamed", WOLF_TAMED_COUNT, new ResourceLocation("textures/entity/wolf/wolf_tame.png")));

        RenderingRegistry.registerEntityRenderingHandler(EntityWolf.class, RenderWolf::new);
    }

    private List<ResourceLocation> getTextures(String rl, int count)
    {
        return this.getTextures(rl, count, null);
    }

    private List<ResourceLocation> getTextures(String rl, int count, ResourceLocation vanilla)
    {
        List<ResourceLocation> textures = new ArrayList<>();

        for (int i = 1; i <= count; i++)
            textures.add(new ResourceLocation(MOD_ID, "textures/entity/" + rl + "/" + i + ".png"));

        if (vanilla != null) textures.add(vanilla);

        return textures;
    }

    public static ResourceLocation getRandomTexture(Entity e, Type type)
    {
        List<ResourceLocation> textures = TEXTURES.get(type);

        UUID id = e.getUniqueID();
        int choice = Math.abs((int) (id.getMostSignificantBits() % textures.size()));

        return textures.get(choice);
    }

    public enum Type
    {
        WOLF_TAMED
    }
}
