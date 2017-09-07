[![Download](https://api.bintray.com/packages/sikeeoh/maven/bubbleseekbar/images/download.svg)](https://bintray.com/sikeeoh/maven/bubbleseekbar)
[![License](http://img.shields.io/badge/License-Apache%202.0-brightgreen.svg?style=flat)](https://opensource.org/licenses/Apache-2.0)

# BubbleSeekBar for Android Renewal!


### This project is a fork of woxingxiao/BubbleSeekBar project.
The project provides flexibility in customization in addition to adding brand new features listed below

* Support custom section text 
	* sectionTextMap (java)
* Support second track visibility
	* bsb\_show\_second\_track (xml)
	* showSecondTrack (java)
	* hideSecondTrack (java)
* The string shown according to the section text attribute are different.
	* bsb\_section\_text\_show\_only\_certain\_values (xml)
	* sectionTextShowOnlyCertainValues(BubbleSeekBar.SectionTextShowOnlyCertainValues.ONLY\_CUSTOM) (java)
* Fixed a bug where the Section Text Visiblity attribute was sometimes not applied.

## Introduce

**A beautiful Android custom seek bar, which has a bubble view with progress appearing upon when seeking. Highly customizable, mostly demands has been considered. `star` or `pull request` will be welcomed**
****
## Screenshot
<img width="45%" alt="demo1" src="https://github.com/sikeeoh/BubbleSeekBar/blob/master/screenshot/demo1.gif"></img>
<img width="45%" alt="demo2" src="https://github.com/sikeeoh/BubbleSeekBar/blob/master/screenshot/demo2.gif"></img>
******
<img width="45%" alt="demo3" src="https://github.com/sikeeoh/BubbleSeekBar/blob/master/screenshot/demo3.gif"></img>
<img width="45%" alt="demo4" src="https://github.com/sikeeoh/BubbleSeekBar/blob/master/screenshot/demo4.gif"></img>

## Download
The **LATEST_VERSION**: [![Download](https://api.bintray.com/packages/sikeeoh/maven/bubbleseekbar/images/download.svg)](https://bintray.com/sikeeoh/maven/bubbleseekbar)

```
  dependencies {
     // compile 'com.sikeeoh.repo:bubbleseekbar:${LATEST_VERSION}'
  }
```

## Usage  
### xml  
```xml
<com.sikeeoh.repo.BubbleSeekBar
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="8dp"
    app:bsb_bubble_color="@color/color_red_light"
    app:bsb_bubble_text_color="@color/colorPrimaryDark"
    app:bsb_max="50.0"
    app:bsb_min="-50"
    app:bsb_progress="0"
    app:bsb_second_track_color="@color/color_red"
    app:bsb_section_count="5"
    app:bsb_section_text_position="bottom_sides"
    app:bsb_show_progress_in_float="true"
    app:bsb_show_section_mark="true"
    app:bsb_show_section_text="true"
    app:bsb_show_thumb_text="true"
    app:bsb_section_text_show_only_certain_values="only_default"
    app:bsb_track_color="@color/color_red_light"/>
```
```xml
<com.sikeeoh.repo.BubbleSeekBar
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="8dp"
    app:bsb_auto_adjust_section_mark="true"
    app:bsb_second_track_color="@color/color_blue"
    app:bsb_section_count="5"
    app:bsb_section_text_position="below_section_mark"
    app:bsb_show_section_mark="true"
    app:bsb_show_section_text="true"
    app:bsb_section_text_show_only_certain_values="only_custom"
    app:bsb_show_thumb_text="true"
    app:bsb_thumb_text_size="18sp"
    app:bsb_touch_to_seek="true"/>
```
### java
```java
mBbubbleSeekBar.getConfigBuilder()
               .min(0.0)
               .max(50)
               .progress(20)
               .sectionCount(5)
               .trackColor(ContextCompat.getColor(getContext(), R.color.color_gray))
               .secondTrackColor(ContextCompat.getColor(getContext(), R.color.color_blue))
               .thumbColor(ContextCompat.getColor(getContext(), R.color.color_blue))
               .showSectionText()
               .sectionTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimary))
               .sectionTextSize(18)
               .showThumbText()
               .thumbTextColor(ContextCompat.getColor(getContext(), R.color.color_red))
               .thumbTextSize(18)
               .bubbleColor(ContextCompat.getColor(getContext(), R.color.color_green))
               .bubbleTextSize(18)
               .showSectionMark()
               .seekBySection()
               .autoAdjustSectionMark()
               .hideSecondTrack()
               .sectionTextMap(sectionTextMap)
               .sectionTextPosition(BubbleSeekBar.TextPosition.BELOW_SECTION_MARK)
               .build();
```
Check out the demo for more details. Or download the apk: [**sample.apk**](https://github.com/sikeeoh/BubbleSeekBar/raw/master/apk/sample.apk)
## Attentions  
- There are two versions of this library.The differences as follow:  

  version | init | getter/setter
  -------- | ---|---
  LATEST_VERSION |xml, java|all attrs

- You must correct the offsets by setting `ScrollListener` when `BubbleSeekBar`'s parent view is scrollable, otherwise the position of bubble appears maybe be wrong. For example:
```java
   mContainer.setOnYourContainerScrollListener(new OnYourContainerScrollListener() {
       @Override
       public void onScroll() {
           // call this method to correct offsets
           mBubbleSeekBar.correctOffsetWhenContainerOnScrolling();
       }
   });
```
- When set `bsb_touch_to_seek` attribute to be `true` , you better not to click **too fast** because the animation may not have enough time to play.
- This library depends `support:appcompat-v7` via **`provided`**, so you don't need to worry about compatibility.

## Attributes  
```xml
<attr name="bsb_min" format="float|reference"/> <!--min < max, default: 0.0f-->
<attr name="bsb_max" format="float|reference"/> <!--min < max, default: 100.0f-->
<attr name="bsb_progress" format="float|reference"/> <!--real time progress value, default: min-->
<attr name="bsb_is_float_type" format="boolean"/> <!--support for float type-->
<attr name="bsb_track_size" format="dimension|reference"/> <!--height of right-track(on the right of thumb), default: 2dp-->
<!--height of left-track(on the left of thumb), default: 2dp higher than right-track's height-->
<attr name="bsb_second_track_size" format="dimension|reference"/>
<attr name="bsb_thumb_radius" format="dimension|reference"/> <!--radius of thumb, default: 2dp higher than left-track's height-->nce"/>
<!--radius of thumb when be dragging, default: 2 times of left-track's height-->
<attr name="bsb_thumb_radius_on_dragging" format="dimension|reference"/>
<attr name="bsb_track_color" format="color|reference"/> <!--color of right-track, default: R.color.colorPrimary-->
<attr name="bsb_second_track_color" format="color|reference"/> <!--color of left-track, default: R.color.colorAccent-->
<attr name="bsb_thumb_color" format="color|reference"/> <!--color of thumb, default: same as left-track's color-->
<attr name="bsb_section_count" format="integer|reference"/> <!--shares of whole progress(max - min), default: 10-->
<attr name="bsb_show_section_mark" format="boolean"/> <!--show demarcation points or not, default: false-->
<attr name="bsb_auto_adjust_section_mark" format="boolean"/> <!--auto scroll to the nearest section_mark or not, default: false-->
<attr name="bsb_show_section_text" format="boolean"/> <!--show section-text or not, default: false-->
<attr name="bsb_show_second_track" format="boolean"/> <!--show second-track or not, default: true-->
<attr name="bsb_section_text_size" format="dimension|reference"/> <!--text size of section-text, default: 14sp-->
<attr name="bsb_section_text_color" format="color|reference"/> <!--text color of section-text, default: same as right-track's color-->
<!--text position of section-text relative to track, sides, bottom_sides, below_section_mark, default: sides-->
<attr name="bsb_section_text_position">
    <enum name="sides" value="0"/>
    <enum name="bottom_sides" value="1"/>
    <enum name="below_section_mark" value="2"/>
</attr>
<!-- the string shown according to the section text attribute are different.
If you do not use this option, the entire data will be displayed. default: NONE(ALL)  -->
<attr name="bsb_section_text_show_only_certain_values">
	<enum name="all" value="0"/>
	<enum name="only_default" value="1"/>
	<enum name="only_custom" value="2"/>
</attr>
<attr name="bsb_section_text_interval" format="integer"/> <!--the interval of two section-text, default: 1-->
<attr name="bsb_show_thumb_text" format="boolean"/> <!--show real time progress-text under thumb or not, default: false-->
<attr name="bsb_thumb_text_size" format="dimension|reference"/> <!--text size of progress-text, default: 14sp-->
<attr name="bsb_thumb_text_color" format="color|reference"/> <!--text color of progress-text, default: same as left-track's color-->
<attr name="bsb_show_progress_in_float" format="boolean"/> <!--show bubble-progress in float or not, default: false-->
<attr name="bsb_touch_to_seek" format="boolean"/> <!--touch anywhere on track to quickly seek, default: false-->
<attr name="bsb_seek_by_section" format="boolean"/> <!--seek by section, the progress may not be linear, default: false-->
<attr name="bsb_bubble_color" format="color|reference"/> <!--color of bubble, default: same as left-track's color-->
<attr name="bsb_always_show_bubble" format="boolean"/> <!--bubble shows all time, default: false-->
<attr name="bsb_always_show_bubble_delay" format="integer"/> <!--the delay duration before bubble shows all the time, default: 200ms-->
<attr name="bsb_hide_bubble" format="boolean"/> <!--hide bubble, default: false-->
```
## License
```
	Copyright 2016 woxingxiao
  	Copyright 2017 sikeeoh

  	Licensed under the Apache License, Version 2.0 (the "License");
  	you may not use this file except in compliance with the License.
  	You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

  	Unless required by applicable law or agreed to in writing, software
  	distributed under the License is distributed on an "AS IS" BASIS,
  	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  	See the License for the specific language governing permissions and
  	limitations under the License.
```
