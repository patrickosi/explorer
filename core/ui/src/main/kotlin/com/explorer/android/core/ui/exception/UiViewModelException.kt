package com.explorer.android.core.ui.exception

class UiViewModelException(name: String) :
    RuntimeException("No ViewModel mapping found for class: $name")
