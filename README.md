# musicController
<img src="/images/Screenshot_20190123-033205_2.png" width=270/>

[![platform](https://img.shields.io/badge/Platform-Android-yellow.svg?style=flat-square)](https://www.android.com)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat-square)](https://android-arsenal.com/api?level=21s)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=flat-square)](https://opensource.org/licenses/MIT)

# Usage
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.as1ngh:musicController:0.1.0'
	}

# Example Usage
1) After adding dependencies implement musicController.MediaPlayerControl, and define the playback results for your controller.
2) Then create a new musicController:


        mMediaController = new musicController(this);
        mMediaController.setMediaPlayer(Activity.this);
        mMediaController.setAnchorView((ViewGroup) findViewById(R.id.fragmentView));
        mMediaController.show(10000);
3) RESULT:
     
     
     <img src="/images/Screenshot_20190123-032947.png" width=270/>
