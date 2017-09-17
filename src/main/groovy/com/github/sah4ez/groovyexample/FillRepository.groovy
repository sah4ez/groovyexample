package com.github.sah4ez.groovyexample

import org.uma.jmetal.algorithm.multiobjective.nsgaii.NSGAII
import org.uma.jmetal.operator.CrossoverOperator
import org.uma.jmetal.operator.MutationOperator
import org.uma.jmetal.operator.SelectionOperator
import org.uma.jmetal.problem.Problem
import org.uma.jmetal.util.evaluator.SolutionListEvaluator

class FillRepository extends NSGAII {

    FillRepository(Problem problem,
                   int maxEvaluations,
                   int populationSize,
                   CrossoverOperator crossoverOperator,
                   MutationOperator mutationOperator,
                   SelectionOperator selectionOperator,
                   SolutionListEvaluator evaluator) {
        super(problem, maxEvaluations, populationSize, crossoverOperator, mutationOperator, selectionOperator, evaluator)
    }
}
