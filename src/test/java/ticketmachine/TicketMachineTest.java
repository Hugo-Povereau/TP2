package ticketmachine;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {
	private static final int PRICE = 50; // Une constante

	private TicketMachine machine; // l'objet à tester

	@Before
	public void setUp() {
		machine = new TicketMachine(PRICE); // On initialise l'objet à tester
	}

	@Test
	// On vérifie que le prix affiché correspond au paramètre passé lors de l'initialisation
	// S1 : le prix affiché correspond à l’initialisation
	public void priceIsCorrectlyInitialized() {
		// Paramètres : message si erreur, valeur attendue, valeur réelle
		assertEquals("Initialisation incorrecte du prix", PRICE, machine.getPrice());
	}

	@Test
	// S2 : la balance change quand on insère de l’argent
	public void insertMoneyChangesBalance() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertEquals("La balance n'est pas correctement mise à jour", 10 + 20, machine.getBalance());           
	}
        
        @Test
	public void montantinséréinsuffisant() {
		machine.insertMoney(10);
		machine.insertMoney(20);
		assertFalse("Argent suffisant", machine.getTotal()>=machine.getPrice());              
	}
        
        @Test
	public void montantinsérésuffisant() {
		machine.insertMoney(30);
		machine.insertMoney(20);
		assertTrue("Argent insuffisant", machine.getTotal()<=machine.getPrice());            
	}
        
        @Test
	public void balanceDécrémentée() {
		machine.insertMoney(30);
		machine.insertMoney(20);
                machine.printTicket();
		assertEquals("Balance non décrémentée", machine.getBalance(),0);             
	}
        
        @Test
	public void total() {
		machine.insertMoney(30);
		machine.insertMoney(30);
                assertFalse("total mal modifié", machine.getTotal()>0);
                machine.printTicket();
		assertEquals("oublie incrémentage total", machine.getTotal(),50);        
	}
        
         public void rendlamonnaie() {
		machine.insertMoney(30);
		machine.insertMoney(30);
                machine.printTicket();
                machine.refund();
                assertTrue("monnaie non rendue", machine.getBalance()==10);
                      
	}
        
        public void ajustelabalance() {
		machine.insertMoney(30);
		machine.insertMoney(30);
                machine.printTicket();
                machine.refund();
                assertTrue("balance mal modifiée", machine.getBalance()==0);
                      
	}

}
