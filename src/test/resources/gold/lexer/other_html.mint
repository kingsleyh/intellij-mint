component Super {

  fun render : Html {
    <div::rangeSlider>
    <div><{effortScale(Number.fromString(sliderPos) |> Maybe.withDefault(0))}></div>
      <input::sliderRange
        value={sliderPos}
        step={Number.toString(step)}
        max={Number.toString(max)}
        min={Number.toString(min)}
        disabled={disabled}
        onChange={changed}
        type="range"/>

      <span::rangeValue>
        <{ sliderPos }>
      </span>
    </div>
  }

}