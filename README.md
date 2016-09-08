Package Minimization

Introduction

An electronics company is planning to sell their products worldwide. In order to supply the new demand, the company is going to create multiple distribution centers around the world.

An optimized profit can be achieved by reducing the shipping cost. Every time a distribution center cannot fulfill an order completely, more than one package will be delivered to the customer and the shipping cost will be increased.

Consider an example which an order has been placed with the items below:

Product	Quantity
Keyboard	1
Monitor	1
Also, the following distribution centers have the products available:

Center	Product	Quantity
Brazil	Keyboard	2
Chile	Monitor	3
The result would be two shipments, one package from Brazil with the keyboards and another package from Chile with the monitors.

Multiple products sent by the same distribution center will be package together, so it is considered just one package.

Problem

The purpose of this problem is to fulfill the order with the minimum possible number of packages. In other words, the result should be the best combination of distribution centers that have the products available in the required quantities.

Note: in case of a tie between two distribution centers, both responses are acceptable.

The input is separated by two parts:

List of distribution centers and the products available in each one of them.
List of products that the order contains and needs to be fulfilled.
Format:

[Country1] [Product1] [Quantity Available]
...
[CountryN] [ProductN] [Quantity Available]
[Product1] [Quantity Needed]
...
[ProductN] [Quantity Needed]
The output is the number of packages followed by the list of distribution centers that will fulfill the order with the product and quantity

Test Examples

Test Case #1

Input

Brazil Keyboard 2
Brazil Mouse 1
Argentina Mouse 2
Keyboard 2
Output

1
Brazil Keyboard 2
Test Case #2

Input

Brazil Keyboard 2
Brazil Mouse 1
Argentina Mouse 2
Keyboard 2
Mouse 1
Output

1
Brazil Keyboard 2
Brazil Mouse 1
Test Case #3

Input

Brazil Keyboard 2
Brazil Mouse 1
Brazil Monitor 1
Chile  Keyboard 2
Chile  Monitor 2
Panama Mouse 2
Argentina Monitor 2
Keyboard 3
Mouse 1
Monitor 2
Output

2
Brazil Keyboard 2
Brazil Mouse 1
Brazil Monitor 1
Chile  Keyboard 1
Chile  Monitor 1