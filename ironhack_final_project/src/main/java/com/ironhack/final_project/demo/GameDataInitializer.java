package com.ironhack.final_project.demo;

import com.ironhack.final_project.enums.Equipable;
import com.ironhack.final_project.model.*;
import com.ironhack.final_project.repository.EffectRepository;
import com.ironhack.final_project.repository.InventoryRepository;
import com.ironhack.final_project.repository.ItemRepository;
import com.ironhack.final_project.repository.PlayerRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameDataInitializer implements CommandLineRunner {
    private final EffectRepository effectRepository;
    private final ItemRepository itemRepository;
    private final InventoryRepository inventoryRepository;
    private final PlayerRepository playerRepository;

    public GameDataInitializer(EffectRepository effectRepository,
                               ItemRepository itemRepository,
                               InventoryRepository inventoryRepository,
                               PlayerRepository playerRepository) {
        this.effectRepository = effectRepository;
        this.itemRepository = itemRepository;
        this.inventoryRepository = inventoryRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        Player system = new Player();
        Player player = new Player();

        Equipment weapon = new Equipment();
        Equipment armor = new Equipment();
        Item spider_key = new Item();
        Resource resource = new Resource();

        Effect effect1 = new Effect();
        effect1.setName("Reposando");
        effect1.setDescription("Nada especial.");
        effect1.setTurns(0);
        effect1.setItems(new ArrayList<>());
        effect1.setPlayers(new ArrayList<>());

        Effect effect2 = new Effect();
        effect2.setName("Ralentizado");
        effect2.setDescription("Ralentiza al objetivo.");
        effect2.setTurns(5);
        effect2.setItems(new ArrayList<>());
        effect2.setPlayers(new ArrayList<>());

        Market market = new Market();
        Inventory inventory = new Inventory();

        weapon.setName("Bastón de Hielo Eterno");
        weapon.setAttack(72);
        weapon.setQuantity(1);
        weapon.setPrice(3300);
        weapon.setWeight(2.6);
        weapon.setDescription("Este bastón mágico emite un frío\n" +
            "perpetuo que congela el aire, permitiendo lanzar proyectiles\n" +
            "de hielo que ralentizan a los enemigos.\n");
        weapon.setEquipmentDescription();
        weapon.getEffect().add(effect2);
        weapon.setInventory(new ArrayList<>());
        weapon.setType(Equipable.WEAPON);
        weapon.setRecipes(new ArrayList<>());

        armor.setName("Armadura de Telaraña Prístina");
        armor.setDefense(33);
        armor.setSpeed(25);
        armor.setQuantity(1);
        armor.setPrice(3300);
        armor.setWeight(15.8);
        armor.setDescription("Esta armadura ligera está tejida cuidadosamente con\n" +
            "hilos de Telaraña Prístina, Proporciona una protección sólida contra\n" +
            "ataques físicos.\n");
        armor.setEquipmentDescription();
        armor.getEffect().add(effect1);
        armor.setInventory(new ArrayList<>());
        armor.setType(Equipable.ARMOR);
        armor.setRecipes(new ArrayList<>());

        spider_key.setName("Llave de la Araña");
        spider_key.setQuantity(1);
        spider_key.setPrice(3300);
        spider_key.setWeight(0.5);
        spider_key.setDescription("Llave hecha de telarañas. Sirve para abrir la\n" +
            "Mazmorra de la Araña en el Bosque Sombrío.");
        spider_key.setAdditionalDescription();
        spider_key.getEffect().add(effect1);
        spider_key.setInventory(new ArrayList<>());
        spider_key.setRecipes(new ArrayList<>());

        resource.setName("Telaraña Prístina");
        resource.setPrice(150);
        resource.setQuantity(20);
        resource.setWeight(0.1);
        resource.setDescription("Una fina y resistente telaraña recolectada de\n" +
            "las arañas místicas del Bosque Sombrío. Utilizada en la\n" +
            "fabricación de armaduras livianas y llaves de araña.\n");
        resource.setAdditionalDescription();
        resource.getEffect().add(effect1);
        resource.setInventory(new ArrayList<>());
        resource.setRecipes(new ArrayList<>());
        resource.setUsedInRecipe(new ArrayList<>(List.of(spider_key)));

        spider_key.getRecipes().add(resource);

        effect1.getItems().addAll(List.of(armor, spider_key, resource));
        effect2.getItems().add(weapon);

        market.setSpace(10000);
        market.getItems().addAll(List.of(weapon, armor, resource));
        market.setPlayer(system);

        inventory.setSpace(20);
        inventory.getItems().add(spider_key);
        inventory.setPlayer(player);

        weapon.getInventory().add(market);
        armor.getInventory().add(market);
        spider_key.getInventory().add(inventory);
        resource.getInventory().add(market);
        resource.setRecipes(List.of(armor, spider_key));

        system.setName("Sistema");
        system.setHealth(1);
        system.setAttack(1);
        system.setDefense(1);
        system.setSpeed(1);
        system.setInventory(market);
        system.setInventory(market);
        system.setGold(1000000000);
        system.setWeight(0);
        system.getStatus().add(effect2);

        player.setName("DragonBoss85");
        player.setHealth(1200);
        player.setAttack(80);
        player.setDefense(65);
        player.setSpeed(40);
        player.setInventory(inventory);
        player.setInventory(inventory);
        player.setGold(27542);
        player.setWeight(inventory.getWeight());
        player.getStatus().add(effect1);

        effect1.getPlayers().add(player);
        effect2.getPlayers().add(system);
        market.setPlayer(system);
        inventory.setPlayer(player);

        /*Útil hacerlo 1 a 1 para testear

        effectRepository.save(effect1);
        effectRepository.save(effect2);
        itemRepository.save(weapon);
        itemRepository.save(armor);
        itemRepository.save(resource);
        itemRepository.save(spider_key);
        inventoryRepository.save(market);
        inventoryRepository.save(inventory);
        playerRepository.save(system);
        playerRepository.save(player);

        Orden de guardado:

        Players contiene inventarios y effects
        Inventario contiene items
        Items contiene effects*/

        effectRepository.saveAll(List.of(effect1, effect2));
        itemRepository.saveAll(List.of(weapon, armor, resource, spider_key));
        inventoryRepository.saveAll(List.of(market, inventory));
        playerRepository.saveAll(List.of(system, player));

        System.out.println("Effects, items, inventories and players created.");
    }
}
