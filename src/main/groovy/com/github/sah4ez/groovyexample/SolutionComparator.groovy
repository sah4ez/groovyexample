package com.github.sah4ez.groovyexample

class SolutionComparator implements Comparator<RepositorySolution>{
    @Override
    int compare(RepositorySolution o1, RepositorySolution o2) {
        def free1 = o1.free()
        def free2 = o2.free()
        return free1 <=> free2
    }
}
