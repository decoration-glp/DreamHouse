package engine.process;



import config.HouseConfig;
import engine.map.Case;
import engine.map.Salon;
import engine.mobile.Meuble;




public class MapBuilder {

	public static Salon buildSalon() {
		return new Salon(HouseConfig.LIGNE_COUNT, HouseConfig.COLUMN_COUNT);
	}

	public static MobileElementManager buildInitMobile(Salon salon) {
		MobileElementManager manager = new MobileElementManager(salon);
		
		intializeAircraft(salon, manager);
		
		return manager;
	}

	private static void intializeAircraft(Salon salon, MobileElementManager manager) {
		Case block = salon.getCase(HouseConfig.LIGNE_COUNT - 1, (HouseConfig.COLUMN_COUNT - 1) / 2);
		Meuble meuble = new Meuble(block);
		manager.set(meuble);

}
}
