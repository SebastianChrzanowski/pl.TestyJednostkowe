package testing;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class MealTest {

    @Test
    void shouldReturnDiscountedPrice() {

        //given
        Meal meal = new Meal(35);

        //when
        int discountedPrice = meal.getDiscountedPrice(7);

        //then
        assertEquals(28, discountedPrice);
        assertThat(discountedPrice,equalTo(28));

    }


    @Test
    void referencesToTheSameObjectShouldbeEqual(){
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = meal1;

        //then
        assertSame(meal1,meal2);
        assertThat(meal1, sameInstance(meal2));

    }

    @Test
    void referencesToTheDifferentObjectShouldbeNotEqual(){
        //given
        Meal meal1 = new Meal(10);
        Meal meal2 = new Meal(10);

        //then
        assertNotSame(meal1,meal2);
        assertThat(meal1,not(sameInstance(meal2)));
    }
    @Test
    void twoMealsShouldBeEqualsWhenPriceAndNameAreTheSame(){
        //given
        Meal meal1 = new Meal(10, "Pizza");
        Meal meal2 = new Meal(10, "Pizza");

        //then
        assertEquals(meal1,meal2);
    }
}