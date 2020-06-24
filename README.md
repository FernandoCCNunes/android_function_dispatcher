function_dispatcher

**Add to gradle:**
*implementation "org.jetbrains.kotlin:kotlin-reflect:1.3.72"*



**val fOnSomethingChanged = FunctionDispatcherNoParams()**

**fOnSomethingChanged.bind(this, this::notifyWhenSomethingHasChanged)**

**fun notifyWhenSomethingHasChanged() {
  ...
}**
