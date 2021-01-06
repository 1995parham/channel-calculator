package com.zolaliran.channelcalculator.controllers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import com.zolaliran.channelcalculator.domain.Channel;

public class ChannelList implements List<Channel> {

	private ArrayList<Channel> channels;

	public ChannelList() {
		channels = new ArrayList<>();
	}

	@Override
	public boolean add(Channel Channel) {
		return channels.add(Channel);
	}

	@Override
	public void add(int index, Channel Channel) {
		channels.add(index, Channel);
	}

	@Override
	public boolean addAll(Collection<? extends Channel> collection) {
		return channels.addAll(collection);
	}

	@Override
	public boolean addAll(int index, Collection<? extends Channel> collection) {
		return channels.addAll(index, collection);
	}

	@Override
	public void clear() {
		channels.clear();
	}

	@Override
	public boolean contains(Object object) {
		return channels.contains(object);
	}

	@Override
	public boolean containsAll(Collection<?> collection) {
		return channels.containsAll(collection);
	}

	@Override
	public Channel get(int index) {
		return channels.get(index);
	}

	@Override
	public int indexOf(Object object) {
		return channels.indexOf(object);
	}

	@Override
	public boolean isEmpty() {
		return channels.isEmpty();
	}

	@Override
	public Iterator<Channel> iterator() {
		return channels.iterator();
	}

	@Override
	public int lastIndexOf(Object object) {
		return channels.lastIndexOf(object);
	}

	@Override
	public ListIterator<Channel> listIterator() {
		return channels.listIterator();
	}

	@Override
	public ListIterator<Channel> listIterator(int index) {
		return channels.listIterator(index);
	}

	@Override
	public boolean remove(Object object) {
		return channels.remove(object);
	}

	@Override
	public Channel remove(int index) {
		return channels.remove(index);
	}

	@Override
	public boolean removeAll(Collection<?> collection) {
		return channels.removeAll(collection);
	}

	@Override
	public boolean retainAll(Collection<?> collection) {
		return channels.retainAll(collection);
	}

	@Override
	public Channel set(int index, Channel Channel) {
		return channels.set(index, Channel);
	}

	@Override
	public int size() {
		return channels.size();
	}

	@Override
	public List<Channel> subList(int fromIndex, int toIndex) {
		return channels.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray() {
		return channels.toArray();
	}

	@Override
	public <T> T[] toArray(T[] array) {
		return channels.toArray(array);
	}
}