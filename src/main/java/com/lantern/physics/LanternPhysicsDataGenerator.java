package com.lantern.physics;

import com.lantern.physics.data.provider.LanternPhysicsEnLanguageProvider;
import com.lantern.physics.data.provider.LanternPhysicsModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class LanternPhysicsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(LanternPhysicsModelProvider::new);
		pack.addProvider(LanternPhysicsEnLanguageProvider::new);
	}
}
