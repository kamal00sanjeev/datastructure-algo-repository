package com.ds.htable;

public class HashTable<K, V> {

	private static int INITIAL_SIZE = 16;
	@SuppressWarnings("rawtypes")
	private HashNode[] hashArr;
	private int size;

	public HashTable() {
		this.hashArr = new HashNode[INITIAL_SIZE];
		this.size = 0;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return getSize() == 0;
	}

	/**
	 * Return null if corresponding key doesn't exist before or return old value and
	 * replace new value
	 * 
	 * @param key
	 * @param val
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public synchronized V put(K key, V val) {
		int hash = getHash(key);
		final HashNode<K, V> entry = new HashNode<>(key, val);
		if (hashArr[hash] == null) {
			hashArr[hash] = entry;
		} else {
			HashNode<K, V> tmpNode = hashArr[hash];

			while (tmpNode != null) {
				if (tmpNode.key.equals(key)) {
					V oldVal = tmpNode.value;
					tmpNode.value = val;
					return oldVal;
				} else {
					tmpNode = tmpNode.next;
				}
				tmpNode.next = entry;
			}
		}
		size++;
		return null;
	}

	@SuppressWarnings("unchecked")
	public synchronized V getValue(K key) {
		int hash = getHash(key);
		if (hashArr[hash] != null) {
			HashNode<K, V> tmpNode = hashArr[hash];
			if (!tmpNode.key.equals(key) && tmpNode.next != null) {
				tmpNode = tmpNode.next;
			}
			return tmpNode.value;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public synchronized V remove(K keyToRemove) {
		int hash = getHash(keyToRemove);
		if (hashArr[hash] == null) {
			return null;
		}
		HashNode<K, V> tmpNode = hashArr[hash];
		while (tmpNode != null) {
			if (tmpNode.key.equals(keyToRemove)) {
				V val = tmpNode.value;
				tmpNode = tmpNode.next;
				this.size--;
				return val;
			}
			tmpNode = tmpNode.next;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String toString() {
		int bucket = 0;
		StringBuilder hashTableStr = new StringBuilder();
		for (HashNode<K, V> entry : hashArr) {
			if (entry == null) {
				continue;
			}
			hashTableStr.append("\n bucket[").append(bucket).append("] = ").append(entry.toString());
			bucket++;
			HashNode<K, V> temp = entry.next;
			while (temp != null) {
				hashTableStr.append(" -> ");
				hashTableStr.append(temp.toString());
				temp = temp.next;
			}
		}
		return hashTableStr.toString();
	}

	private int getHash(K key) {
		if (key == null) {
			return 0;
		}
		int h = key.hashCode() % INITIAL_SIZE;
		return h < 0 ? -h : h;
	}

	private static class HashNode<K, V> {
		K key;
		V value;
		HashNode<K, V> next;

		public HashNode(K key, V val) {
			this.key = key;
			this.value = val;
			this.next = null;
		}

		@Override
		public String toString() {
			return "[" + key + ", " + value + "]";
		}

	}

}
