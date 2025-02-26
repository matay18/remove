package program16;

/**
* @author:	 	Maya Taylor
* Date:   	 	FEB2025
* Course: 	 	APCSA 3RD
* Description:	Test for BinaryTree and prints
*/

public class TreeDriver 
{
	public static void main(String[] args)
	{
		BinaryTree<String> spruce = new BinaryTree<String>();
		spruce.add("L");
		spruce.add("D");
		spruce.add("A");
		spruce.add("F");
		spruce.add("B");
		spruce.add("R");
		spruce.add("M");
		spruce.add("U");
		spruce.add("T");
		spruce.add("V");
		
		System.out.println(spruce.toStringPreOrder());
		System.out.println(spruce.toStringinOrder());
		
		spruce.remove("A");
		System.out.println("Post A removal:");
		System.out.println(spruce.toStringinOrder());
		System.out.println(spruce.toStringPreOrder());
		
		spruce.remove("B");
		System.out.println("Post B removal:");
		System.out.println(spruce.toStringinOrder());
		System.out.println(spruce.toStringPreOrder());
		
		spruce.remove("U");
		System.out.println("Post U removal:");
		System.out.println(spruce.toStringinOrder());
		System.out.println(spruce.toStringPreOrder());
		
		spruce.remove("R");
		System.out.println("Post R removal:");
		System.out.println(spruce.toStringinOrder());
		System.out.println(spruce.toStringPreOrder());
		
		spruce.remove("L");
		System.out.println("Post L removal:");
		System.out.println(spruce.toStringinOrder());
		System.out.println(spruce.toStringPreOrder());
		
		System.out.println("Height: " + spruce.height());
		System.out.println("contains M: " + spruce.search("M"));
		System.out.println("contains B: " + spruce.search("B"));
		
		spruce.remove("D");
		System.out.println("Post D removal:"+spruce.toStringPreOrder());
		spruce.remove("F");
		System.out.println("Post F removal:"+spruce.toStringPreOrder());
		spruce.add("N");
		System.out.println("Post N add:"+spruce.toStringPreOrder());
		spruce.remove("M");
		System.out.println("Post M removal:"+spruce.toStringPreOrder());
		
		/*spruce.remove("T");
		spruce.remove("V");
		spruce.remove("M");
		System.out.println(spruce.toStringPreOrder());*/
		
	}
}

/*
{L{D{A{B}}{F}}{R{M}{U{T}{V}}}}
{{{A{B}}D{F}}L{{M}R{{T}U{V}}}}
Post A removal:
{{{B}D{F}}L{{M}R{{T}U{V}}}}
{L{D{B}{F}}{R{M}{U{T}{V}}}}
Post B removal:
{{D{F}}L{{M}R{{T}U{V}}}}
{L{D{F}}{R{M}{U{T}{V}}}}
Post U removal:
{{D{F}}L{{M}R{{T}V}}}
{L{D{F}}{R{M}{V{T}}}}
Post R removal:
{{D{F}}L{{M}T{V}}}
{L{D{F}}{T{M}{V}}}
Post L removal:
{{D{F}}M{T{V}}}
{M{D{F}}{T{V}}}
Height: 3
contains M: true
contains B: false
Post D removal:{M{F}{T{V}}}
Post F removal:{M{T{V}}}
Post N add:{M{T{N}{V}}}
Post M removal:{T{N}{V}}


{F{D}}
*/ 
