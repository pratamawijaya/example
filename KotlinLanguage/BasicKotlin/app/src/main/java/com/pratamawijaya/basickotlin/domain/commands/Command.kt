package com.pratamawijaya.basickotlin.domain.commands

/**
 * Created by : pratama - set.mnemonix@gmail.com
 * Date : 10/24/15
 * Project : BasicKotlin
 */
public interface Command<T> {
    fun execute(): T
}