package telran.util.shapes;


	import java.util.function.Predicate;

	public class  Utilites {
	
		public static <T> T[] search(T[] array, Predicate<T> predicate) {
		
			T[] arResult = java.util.Arrays.copyOf(array, array.length);
			int index = 0;
			for(int i = 0; i < array.length; i++) {
				if(predicate.test(array[i])) {
					arResult[index++] = array[i];
				}
			}
			return java.util.Arrays.copyOf(arResult,index);
		}
		public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
		
			return search(array, predicate.negate());
		}
		public static <T> T[] add (T[] array, T element) {
			T[] result = java.util.Arrays.copyOf(array, array.length + 1);
			result[array.length] = element;
			return result;
		
		}
	}

