package com.example.storybook

object Constants {
    fun getStoryList():ArrayList<Story>{
        val storyList= ArrayList<Story >()
        val story1=Story(R.string.title1,R.string.story1,R.string.moral1,R.drawable.rv_image1,R.drawable.image1)
        storyList.add(story1)
        val story2=Story(R.string.title2,R.string.story2,R.string.moral2,R.drawable.rv_image2,R.drawable.image2)
        storyList.add(story2)
        val story3=Story(R.string.title3,R.string.story3,R.string.moral3,R.drawable.rv_image3,R.drawable.image3)
        storyList.add(story3)
        val story4=Story(R.string.title4,R.string.story4,R.string.moral4,R.drawable.rv_image4,R.drawable.image4)
        storyList.add(story4)
        val story5=Story(R.string.title5,R.string.story5,R.string.moral5,R.drawable.rv_image5,R.drawable.image5)
        storyList.add(story5)
        val story6=Story(R.string.title6,R.string.story6,R.string.moral6,R.drawable.rv_image6,R.drawable.image6)
        storyList.add(story6)
        val story7=Story(R.string.title7,R.string.story7,R.string.moral7,R.drawable.rv_image7,R.drawable.image7)
        storyList.add(story7)
        val story8=Story(R.string.title8,R.string.story8,R.string.moral8,R.drawable.rv_image8,R.drawable.image8)
        storyList.add(story8)
        val story9=Story(R.string.title9,R.string.story9,R.string.moral9,R.drawable.rv_image9,R.drawable.image9)
        storyList.add(story9)
        val story10=Story(R.string.title10,R.string.story10,R.string.moral10,R.drawable.rv_image10,R.drawable.image10)
        storyList.add(story10)
        return storyList

    }
}