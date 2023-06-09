package model.map;

import model.Virologist;

import java.security.SecureRandom;

/**
 * Olyan mező, amelyen anyag gyüjthető
 */
public class Warehouse extends Field
{
	/**
	 * Ennyivel növeli a virológusok anyagát
	 */
	private int delta = 5;

	private SecureRandom random = new SecureRandom();

	/**
	 * Anyag gyüjtése
	 * Nem determinisztikus esetben a paraméterül kapott virológus anyagkészletét deltával növeli meg, random választva a 2 fajta anyag közül
	 * Determinisztikus esetben a paraméterül kapott virológus anyagkészletét deltával növeli meg, a kiválasztott anyag közül
	 * @param v gyüjtő virológus
	 */
	@Override
	public void CollectMaterial(Virologist v) {
		int r = random.nextInt(2) ;
		if (r == 0) {
			v.AddAminoAcid(delta);
		}
		else {
			v.AddNucleotide(delta);
		}
	}

	/**
	 * A mezőn az anyagok tönkretételét szimbolizálja, nem vehető fel anyag ezután a mezőről
	 */
	@Override
	public void DestroyMaterial(){
		delta = 0;
	}
}
