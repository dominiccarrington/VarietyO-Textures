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

package com.ragegamingpe.varietyotextures.render;

import com.ragegamingpe.varietyotextures.VarietyOTextures;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.util.ResourceLocation;

public class RenderOcelot extends net.minecraft.client.renderer.entity.RenderOcelot
{
    public RenderOcelot(RenderManager manager)
    {
        super(manager);
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityOcelot entity)
    {
        if (entity.isTamed())
            return VarietyOTextures.getRandomTexture(entity, VarietyOTextures.Type.OCELOT_TAMED);
        return super.getEntityTexture(entity);
    }
}
