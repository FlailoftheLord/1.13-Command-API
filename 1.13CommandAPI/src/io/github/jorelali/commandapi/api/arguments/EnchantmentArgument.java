package io.github.jorelali.commandapi.api.arguments;

import org.bukkit.enchantments.Enchantment;

import com.mojang.brigadier.arguments.ArgumentType;

import io.github.jorelali.commandapi.api.CommandPermission;
import io.github.jorelali.commandapi.api.SemiReflector;

@SuppressWarnings("unchecked")
public class EnchantmentArgument implements Argument, OverrideableSuggestions {

	ArgumentType<?> rawType;
	
	/**
	 * An Enchantment argument. Represents an enchantment for items 
	 */
	public EnchantmentArgument() {
		rawType = SemiReflector.getNMSArgumentInstance("ArgumentEnchantment");
	}
	
	@Override
	public <T> ArgumentType<T> getRawType() {
		return (ArgumentType<T>) rawType;
	}

	@Override
	public <V> Class<V> getPrimitiveType() {
		return (Class<V>) Enchantment.class;
	}

	@Override
	public boolean isSimple() {
		return false;
	}
	
	private String[] suggestions;
	
	@Override
	public EnchantmentArgument overrideSuggestions(String... suggestions) {
		this.suggestions = suggestions;
		return this;
	}
	
	@Override
	public String[] getOverriddenSuggestions() {
		return suggestions;
	}
	
	private CommandPermission permission = CommandPermission.NONE;
	
	@Override
	public EnchantmentArgument withPermission(CommandPermission permission) {
		this.permission = permission;
		return this;
	}

	@Override
	public CommandPermission getArgumentPermission() {
		return permission;
	}
}
