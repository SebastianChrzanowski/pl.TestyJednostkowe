package testing;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test

    void newlyCreatedAccountShouldNotBeActive(){
        //given
        Account newAccount = new Account();

        //then
        assertFalse(newAccount.isActive());
    //    assertThat(newAccount.isActive(), equalTo(false)); //HAMCREST
   //     assertThat(newAccount.isActive(), is(false)); //HAMCREST

        assertThat(newAccount.isActive()).isFalse();


    }

 @Test
 void activeAccountShouldHaveActiveFlagSet(){
        //given
     Account newAccount = new Account();

     //when
     newAccount.activate();

     //then
     assertTrue(newAccount.isActive());
  //  assertThat(newAccount.isActive(), equalTo(true));
 }


@Test
    void newAccountShouldNotBeActiveAfterCreation(){
        //given
        Account newAccount = new Account();
        assertFalse(newAccount.isActive(),"Tutaj mozemy wpisac jakas wiadomosc, gdyby asercja sie nie powiodla");

    }
 @Test
 void accountShouldBeActiveAfterActivation(){
    //given
     Account newAccount = new Account();
     assertFalse(newAccount.isActive());

     //when
     newAccount.activate();

     //then
     assertTrue(newAccount.isActive());
   //  assertFalse(newAccount.isActive());
 }




 @Test
    void newlyCreateAccountShouldNotHaveDefoultDeliveryAdress(){
    //given
     Account account = new Account();

     //when
     Address address = account.getDefaultDeliveryAddress();

     //then
     assertNull(address);
 }

 @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet(){

    //given
     Address address = new Address("Krakowska","67c");
     Account account = new Account();
     account.setDefaultDeliveryAddress(address);
     //when
    Address defaultAdress = account.getDefaultDeliveryAddress();
     //then
     assertNotNull(defaultAdress);
    // assertThat(defaultAdress, is(notNullValue()));
 }

@Test
    void newAccountWithNotNullAddressShouldBeActive(){
        //given
    Address address = new Address("Gorkiego", "10/12");

    //when
    Account account = new Account(address);

    //then
    assumingThat(address != null, ()-> {
            assertTrue(account.isActive());
            });





}
    @Test
    void invalidEmailShouldThrowExeption(){
        //given
        Account account1 = new Account();

        //when
        //then
        assertThrows(IllegalArgumentException.class, ()->account1.setEmail("Wrong_email"));
    }
}
