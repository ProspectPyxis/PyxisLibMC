package prospectpyxis.pyxislib.client;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import org.lwjgl.util.Color;

import javax.annotation.Nonnull;

public class RendererUtils {

    public static final float UV_CORRECT = 1/50000f;

    public static float getMinUCorrected(TextureAtlasSprite tex) {
        return tex.getMinU() + UV_CORRECT;
    }

    public static float getMaxUCorrected(TextureAtlasSprite tex) {
        return tex.getMaxU() - UV_CORRECT;
    }

    public static float getMinVCorrected(TextureAtlasSprite tex) {
        return tex.getMinV() + UV_CORRECT;
    }

    public static float getMaxVCorrected(TextureAtlasSprite tex) {
        return tex.getMaxV() - UV_CORRECT;
    }

    public static int getLightMapBlockLight(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return (state.getPackedLightmapCoords(worldIn, pos)) & 0xFFFF;
    }

    public static int getLightMapSkyLight(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return (state.getPackedLightmapCoords(worldIn, pos)) >> 16 & 0xFFFF;
    }

    /**
     * Renders one face of a block.
     *
     * @param buffer the BufferBuilder object to render to.
     * @param facing the face to be rendered.
     * @param xoff the x offset to render to.
     * @param yoff the y offset to render to.
     * @param zoff the z offset to render to.
     * @param color the color object for this face.
     * @param tx the TextureAtlasSprite for the texture that is to be drawn.
     * @param skylight the skylight lightmap value.
     * @param blocklight the blocklight blockmap value.
     */
    public static void renderFace(BufferBuilder buffer, @Nonnull EnumFacing facing, float xoff, float yoff, float zoff, Color color, TextureAtlasSprite tx, int skylight, int blocklight) {
        switch(facing) {
            case UP:
                buffer.pos(xoff, yoff + 1, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff + 1, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1,  yoff + 1, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff + 1, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                break;
            case DOWN:
                buffer.pos(xoff + 1, yoff, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                break;
            case NORTH:
                buffer.pos(xoff + 1, yoff + 1, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff + 1, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                break;
            case SOUTH:
                buffer.pos(xoff, yoff + 1, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff + 1, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                break;
            case EAST:
                buffer.pos(xoff + 1, yoff + 1, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff + 1, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff + 1, yoff, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                break;
            case WEST:
                buffer.pos(xoff, yoff + 1, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff + 1, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMinVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff, zoff + 1).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMaxUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                buffer.pos(xoff, yoff, zoff).color(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha()).tex(getMinUCorrected(tx), getMaxVCorrected(tx)).lightmap(skylight, blocklight).endVertex();
                break;
        }
    }

    /**
     * Renders a full cube with flat lighting.
     *
     * @param buffer the BufferBuilder to draw to.
     * @param xoff the x offset to draw to.
     * @param yoff the y offset to draw to.
     * @param zoff the z offset to draw to.
     * @param col the color object for this cube.
     * @param tx the TextureAtlasSprite for the texture that needs to be drawn.
     * @param world the IBlockAccess object to get lighting data from.
     * @param state the IBlockState to get lighting data from.
     * @param pos the position of the block that is to be rendered.
     */
    public static void renderCubeWithLighting(
            BufferBuilder buffer,
            float xoff, float yoff, float zoff,
            Color col, TextureAtlasSprite tx, IBlockAccess world, IBlockState state, BlockPos pos
    ) {
        int skyLightOffset;
        int blockLightOffset;
        for (EnumFacing facing : EnumFacing.values()) {
            skyLightOffset = getLightMapSkyLight(state, world, pos.offset(facing));
            blockLightOffset = getLightMapBlockLight(state, world, pos.offset(facing));
            renderFace(buffer, facing, xoff, yoff, zoff, col, tx, skyLightOffset, blockLightOffset);
        }
    }
}
