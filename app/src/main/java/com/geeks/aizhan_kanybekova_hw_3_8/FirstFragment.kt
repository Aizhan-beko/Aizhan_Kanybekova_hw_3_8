package com.geeks.aizhan_kanybekova_hw_3_8
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.geeks.aizhan_kanybekova_hw_3_8.databinding.FragmentFirstBinding


    class FirstFragment(override val FirstFragmentDirections: Any) : Fragment(), CartoonItemClick {
        private val cartoonList: ArrayList<Cartoon>
            get() = arrayListOf(
                Cartoon(
                    "The Yogi Bear Show", "Adventure",
                    "https://m.media-amazon.com/images/M/MV5BOTI5NjgxNGEtNGYzNi00YWRiLTk3OTctY2JkNWIzOGEyZGZjXkEyXkFqcGdeQXVyODk1MjAxNzQ@._V1_UX140_CR0,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "Popeye the Sailor", "Comedy",
                    "https://m.media-amazon.com/images/M/MV5BOWM5MDUwZDktZDlmMi00M2ZkLWFjN2YtZmRmZDFjZTc0NWZiXkEyXkFqcGdeQXVyMzI4MTk3MTY@._V1_UY209_CR4,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "The Secret Squirrel Show", "Crime",
                    "https://m.media-amazon.com/images/M/MV5BNDUyNzBjZWYtZjFlYy00ZGY0LTlkMDgtNmQ5N2U5ZGFiMTBhXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_UY209_CR3,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "The Perils of Penelope Pitstop", "Crime",
                    "https://m.media-amazon.com/images/M/MV5BNTE0OWM2ZWItYjY5OS00NzhhLWI2YzUtZjFiNTg4N2FhMjBhXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_UY209_CR4,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "Duck Dodgers", "Short",
                    "https://m.media-amazon.com/images/M/MV5BZjg0OWIyMzItYzJkZi00NWI1LWE3ZTMtMTlmYjE4OTM4Mjg0XkEyXkFqcGdeQXVyMTQ4NTcxNTI0._V1_UY209_CR9,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "The Magilla Gorilla Show", "Family",
                    "https://m.media-amazon.com/images/M/MV5BN2JhMzZmZjQtNmFkMy00ZGI5LThhZGMtNjY2MWRmYTFhMzkxXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_UY209_CR7,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "Top cat", "Comedy",
                    "https://m.media-amazon.com/images/M/MV5BMGY4NGM5NDAtNzE0OC00YjM0LTkxMmEtNTExOWUxOTY0MTJjXkEyXkFqcGdeQXVyNTE1NjY5Mg@@._V1_UY209_CR3,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "Disneyland", "Drama",
                    "https://m.media-amazon.com/images/M/MV5BNzEzMzQzMDc0Nl5BMl5BanBnXkFtZTcwMTk5ODczMQ@@._V1_UY209_CR4,0,140,209_AL_.jpg"
                ),
                Cartoon(
                    "Avatar", "Fantasy",
                    "https://imgix.ranker.com/user_node_img/26/517050/original/517050-photo-u-1880042972?auto=format&q=60&fit=crop&fm=pjpg&dpr=2&crop=faces&h=125&w=125"
                ),
                Cartoon(
                    "Clone wars", "Fantasy",
                    "https://imgix.ranker.com/user_node_img/425/8489700/original/8489700-photo-u-1141314145?auto=format&q=60&fit=crop&fm=pjpg&dpr=2&crop=faces&h=125&w=125"
                ),
            )

        private lateinit var binding: FragmentFirstBinding
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            binding = FragmentFirstBinding.inflate(layoutInflater)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)

            val layoutManager = GridLayoutManager(requireContext(), 2)
            binding.rvCartoons.layoutManager = layoutManager

            val adapter = CartoonAdapter(cartoonList, this)
            binding.rvCartoons.adapter = adapter
        }

        override fun onItemClick(cartoon: Cartoon) {
            val navDirections = actionFirstFragmentToSecondFragmentInNewGraph(cartoon)
            findNavController().navigate(navDirections)
        }

        private fun actionFirstFragmentToSecondFragmentInNewGraph(cartoon: Cartoon): NavDirections {
            val action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragmentInNewGraph(cartoon)
            return action

        }
    }
}
