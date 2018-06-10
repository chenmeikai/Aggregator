/**
 * 
 */
package com.chenmeikai.test;

/**
 * 单例模式 懒汉
 * @author Administrator
 *
 */
public class SingletonLayer {
	
	private SingletonLayer() {
		
	}
	
	private static SingletonLayer singleton ;
	
	
	public static SingletonLayer getSinleton() {
		
		if(singleton==null) {
			synchronized (SingletonLayer.class) {
				if(singleton==null) {
					singleton =new SingletonLayer();
				}
			}
		}
		return singleton;
	}

}
