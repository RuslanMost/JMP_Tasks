package com.jmpprogram

import spock.lang.Specification

class BasketWeightCalculatorTest extends Specification {

    def "one-item"() {
        given:
        def weightCalculator = new BasketWeightCalculator()

        when: "add only one item"
        weightCalculator.addItem(a)

        then: "expect value of the item"
        weightCalculator.getTotalWeight() == b

        where:
        a | b
        5 | 5
    }

    def "two-items"() {
        given:
        def weightCalculator = new BasketWeightCalculator()

        when: "add two items in the basket"
        weightCalculator.addItem(a)
        weightCalculator.addItem(b)

        then: "expect the sum of both items"
        weightCalculator.getTotalWeight() == c

        where:
        a  | b || c
        13 | 5 || 18
    }

    def "order-of-items-does-not-matter"() {
        given:
        def weightCalculator1 = new BasketWeightCalculator()
        def weightCalculator2 = new BasketWeightCalculator()

        when: "add same items but with different order"
        weightCalculator1.addItem(a)
        weightCalculator1.addItem(b)

        weightCalculator2.addItem(b)
        weightCalculator2.addItem(a)

        then: "expect both baskets to weigh the same"
        weightCalculator1.getTotalWeight() == e
        weightCalculator2.getTotalWeight() == e

        where:
        a | b  || e
        5 | 13 || 18
        2 | 16 || 18
    }
}
